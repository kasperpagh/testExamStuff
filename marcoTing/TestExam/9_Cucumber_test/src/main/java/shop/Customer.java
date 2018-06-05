package shop;

public class Customer {
    private double vallet;

    public Customer(double vallet) {
        this.vallet = vallet;
    }

    public double getVallet() {
        return vallet;
    }

    public void addMoney(double money){vallet+=money;};

    public double useMoney(double money){
        if (vallet >= money) {
            vallet = vallet - money;
            return money;
        } else {
            System.out.println("You are broke man... can't use: "+money +" while you only have: " + vallet);
            return 0;
        }
    }
}
