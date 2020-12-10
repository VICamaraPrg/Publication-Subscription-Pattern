package SubscriptorObject;

import ObservedObject.SpaceStation;
import Superclass.SpaceAgency;
import java.beans.PropertyChangeListener;
import java.beans.VetoableChangeListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;

public class CNSA extends SpaceAgency implements PropertyChangeListener,
        VetoableChangeListener {

    private int budget;
    private int oldBudget;
    private int diff;

    public CNSA(String nombre, int presupuesto) {
        super(nombre, presupuesto);
    }

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        if (pce.getPropertyName().equals(SpaceStation.PROP_RAIN)) {
            oldBudget = GetBudget();
            budget += +5;
            diff = (budget - oldBudget);
            System.out.println(GetName() + " budget " + GetBudget()
                    + " (" + diff + ")");
        } else if (pce.getPropertyName().equals(SpaceStation.PROP_CYCLON)) {
            oldBudget = GetBudget();
            budget += +2;
            diff = (budget - oldBudget);
            System.out.println(GetName() + " budget " + GetBudget()
                    + " (" + diff + ")");
        } else if (pce.getPropertyName().equals(SpaceStation.PROP_MICROSCOPIC_LIFE)) {
            oldBudget = GetBudget();
            budget += +10;
            diff = (budget - oldBudget);
            System.out.println(GetName() + " budget " + GetBudget()
                    + " (" + diff + ")");
        } else if (pce.getPropertyName().equals(SpaceStation.PROP_AV_CIV)) {
            budget = 0;
            System.out.println(GetName() + " withdraws for Venus conquest. "
                    + GetBudget());
        } else if (pce.getPropertyName().equals(SpaceStation.PROP_STRAWBERRY)) {
            oldBudget = GetBudget();
            budget += +10;
            diff = (budget - oldBudget);
            System.out.println(GetName() + " budget " + GetBudget()
                    + " (" + diff + ")");
        } else if (pce.getPropertyName().equals(SpaceStation.PROP_MITHRIL)) {
            oldBudget = GetBudget();
            budget += -5;
            diff = (budget - oldBudget);
            System.out.println(GetName() + " budget " + GetBudget()
                    + " (" + diff + ")");
        }
    }

    @Override
    public void vetoableChange(PropertyChangeEvent evt)
            throws PropertyVetoException {

    }

    @Override
    public int GetBudget() {
        return budget;
    }

}
