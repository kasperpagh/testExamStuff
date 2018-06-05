import React, { Component } from 'react';
import '../App.css';
import Paper from '@material-ui/core/Paper';
import { withStyles, CircularProgress, TableHead, Table, TableRow, TableCell, TableBody, Divider } from '@material-ui/core';
import Input from '@material-ui/core/Input';
import Send from '@material-ui/icons/Send';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';

const styles = theme => ({
    root: {
        marginTop: theme.spacing.unit * 2,
        display: 'block',
        flexWrap: 'wrap',
        width: '75%',
        margin: 'auto',
        padding: '10px',
        flexGrow: 1
    },
    input: {
        margin: theme.spacing.unit,
    },
    rightIcon: {
        marginLeft: theme.spacing.unit,
    },
    loader: {
        marginTop: theme.spacing.unit *2
    }
});

class InputCity extends Component {
    constructor(props){
        super(props)

        this.state = {
            input: "",
            res: [],
            loading: false,
            err: undefined
        }
    }

    updateCity = (e) => {
        //this.props.dbChange(e.target.value);
        this.setState({input: e.target.value});
    }

    runQuery = () => {
        console.log("check")
        this.callApi()
            .then(res => {
                this.setState({res: res, loading: false})
            })
            .catch(err => {
                this.setState({err: err, loading: false})
            })
        
        
    }

    callApi = async () => {
        this.setState({loading: true});
        const res = await fetch('http://167.99.237.199:8080/api/' + this.props.config.db + '/books/' + this.state.input, {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });
        const body = await res.json();
        if(res.status !== 200) throw Error(body.message);
        return body;
    }


    render() {
        const { classes } = this.props

        return (
            <Paper className={classes.root}>
                <Input id="city" placeholder="Input City Name" onChange={this.updateCity} value={this.state.input} className={classes.input}/>
                <Button id="run" className={classes.button} variant="raised" color="primary" onClick={this.runQuery}>
                    Query
                    <Send className={classes.rightIcon}></Send>
                </Button>
                <br/>
                <br/>
                <br/>
                <Divider></Divider>
                <Typography variant="headline" component="h2">
                    Results:
                </Typography>
                {this.state.err && <p>{this.state.err.message}</p>}
                {this.state.loading && <CircularProgress id={"loader"} className={classes.loader}/>}
                <Table>
                    <TableHead>
                        <TableRow>
                            <TableCell>Title</TableCell>
                            <TableCell>Author</TableCell>
                            <TableCell>Release Date</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>

                    
                {
                    this.state.res.map((book, i)=>{
                        //const book = this.state.res[i];
                        return <TableRow key={i}>
                                    <TableCell>{book.title}</TableCell>
                                    <TableCell style={{width: '20em',}}>{book.author.name}</TableCell>
                                    <TableCell style={{width: '6em',}}>{book.releaseDate}</TableCell>
                                </TableRow>
                    })
                }
                    </TableBody>
                </Table>
            </Paper> 
        );
      }
}

export default withStyles(styles)(InputCity);
