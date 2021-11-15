import java.util.ArrayList;

public class PortfolioManager {

    private ArrayList<Investment> investments;

    public ArrayList<Investment> getInvestments() {
        return investments;
    }

    public Investment checkInvestment(String symb) {
        if (investments != null) {
            for (Investment investments : investments) {
                if (investments.getSymbol().equalsIgnoreCase(symb)) {
                    return investments;
                } else if (investments.getName().contains(symb)) {
                    return investments;
                }
            }
        }
        return null;
    }

    public String rangeInvestment(double upper, double lower) {
        String retval = "";
        if (investments != null) {
            for (Investment investmentr : investments) {
                if (investmentr.getPrice() <= upper && investmentr.getPrice() >= lower) {
                    retval += investmentr.toString() + "\n";
                }
            }
        }
        if (retval != "") {
            return retval;
        } else {
            return "No Investments found in the Given Range";
        }
    }

    public void addInvestments(Investment investment) {
        if (investments == null) {
            investments = new ArrayList<>();
        }
        investments.add(investment);
    }
}
