package IntermediaryObject;

import ObservedObject.SpaceStation;
import static ObservedObject.SpaceStation.*;
import java.beans.PropertyChangeListener;
import java.beans.VetoableChangeListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.beans.VetoableChangeSupport;
import java.beans.PropertyVetoException;

public class OTAN implements PropertyChangeListener,
        VetoableChangeListener {

    private PropertyChangeSupport propertySupportOTAN;
    private VetoableChangeSupport vetoableSupportOTAN;

    public OTAN() {
        propertySupportOTAN = new PropertyChangeSupport(this);
        vetoableSupportOTAN = new VetoableChangeSupport(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        if (pce.getPropertyName().equals(SpaceStation.PROP_RAIN)) {
            System.out.println("OTAN INFORMS TO AGENCIES: "
                    + "DETECTED CLOUDS FORMING ACID RAIN!"
                    + "\n*************************************************************");
            propertySupportOTAN.firePropertyChange(PROP_RAIN, pce.getOldValue(), pce.getNewValue());
        } else if (pce.getPropertyName().equals(SpaceStation.PROP_CYCLON)) {
            System.out.println("OTAN INFORMS TO AGENCIES: \n"
                    + "DETECTED CYCLONS OF 500KM2 AT 1000KM/H!\n"
                    + "*****************************************");
            propertySupportOTAN.firePropertyChange(PROP_CYCLON, pce.getOldValue(), pce.getNewValue());
        } else if (pce.getPropertyName().equals(SpaceStation.PROP_MICROSCOPIC_LIFE)) {
            System.out.println("OTAN INFORMS TO AGENCIES: \n"
                    + "DETECTED PRESSENCE OF MICROORGANISMS AT AIR!\n"
                    + "**************************************");
            propertySupportOTAN.firePropertyChange(PROP_MICROSCOPIC_LIFE, pce.getOldValue(), pce.getNewValue());
        } else if (pce.getPropertyName().equals(SpaceStation.PROP_AV_CIV)) {
            System.out.println("OTAN INFORMS TO AGENCIES:\n"
                    + "DETECTED A POSSIBLE ADVANCED CIVILIZATION!\n"
                    + "*****************************************");
            propertySupportOTAN.firePropertyChange(PROP_AV_CIV, pce.getOldValue(), pce.getNewValue());
        } else if (pce.getPropertyName().equals(SpaceStation.PROP_STRAWBERRY)) {
            System.out.println("OTAN INFORMS TO AGENCIES:\n"
                    + "DETECTED PRESSENCE OF GROWING STRAWBERRIES!\n"
                    + "***********************************************");
            propertySupportOTAN.firePropertyChange(PROP_STRAWBERRY, pce.getOldValue(), pce.getNewValue());
        } else if (pce.getPropertyName().equals(SpaceStation.PROP_MITHRIL)) {
            System.out.println("OTAN INFORMS TO AGENCIES:\n"
                    + "DETECTED PLENTY OF MITHRIL AT THE MOUNTAINS.\n"
                    + "********************************************");
            propertySupportOTAN.firePropertyChange(PROP_MITHRIL, pce.getOldValue(), pce.getNewValue());
        }
    }

//Listeners
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupportOTAN.addPropertyChangeListener(listener);
    }

    public void remPropertyChangeListener(PropertyChangeListener listener) {
        propertySupportOTAN.removePropertyChangeListener(listener);
    }

    public void addVetoChangeListener(VetoableChangeListener listener) {
        vetoableSupportOTAN.addVetoableChangeListener(listener);
    }

    public void remVetoChangeListener(VetoableChangeListener listener) {
        vetoableSupportOTAN.addVetoableChangeListener(listener);
    }

    @Override
    public void vetoableChange(PropertyChangeEvent pce) throws PropertyVetoException {
        if (pce.getPropertyName().equals(SpaceStation.PROP_RAIN)) {
            if ((int) pce.getNewValue() <= 2) {
                vetoableSupportOTAN.fireVetoableChange(PROP_RAIN, 0, 0);
                throw new PropertyVetoException("\nEveything is alright!", pce);
            }
        } else if (pce.getPropertyName().equals(SpaceStation.PROP_AV_CIV)) {
            if ((int) pce.getNewValue() <= 2) {
                vetoableSupportOTAN.fireVetoableChange(PROP_AV_CIV, 0, 0);
                throw new PropertyVetoException("\nEveything is alright!", pce);
            }
        }
    }
}
