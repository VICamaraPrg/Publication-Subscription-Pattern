package Superclass;

public class SpaceAgency {

    private String name;
    private int budget;

    public SpaceAgency(String name, int budget) {
        this.name = name;
        this.budget = budget;
    }

    //Getters
    public String GetName() {
        return name;
    }

    public int GetBudget() {
        return budget;
    }

    public void EnoughBudget() {
        if (GetBudget() >= 50) {
            System.out.println("\n" + GetName() + " will send a tripulated "
                    + "space ship to Venus, with a total of " + GetBudget()
                    + " billions of Euros.\n");
        }
    }

    @Override
    public String toString() {
        return ("Budget of: " + GetName() + ": " + GetBudget() + " billions of Euros.");
    }
}
