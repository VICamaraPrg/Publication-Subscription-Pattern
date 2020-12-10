package ObservedObject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;

public class SpaceStation {

    public final static String PROP_RAIN = "IT RAINS";
    public final static String PROP_CYCLON = "FAST CYCLON";
    public final static String PROP_MICROSCOPIC_LIFE =  "MICROSCOPIC LIFE";
    public final static String PROP_AV_CIV = "ADVANCED CIV.";
    public final static String PROP_STRAWBERRY = "PLANTS OF STRAWBERRY";
    public final static String PROP_MITHRIL = "MITHRIL";

    private boolean acidRain = false, cyclonF10 = false,
            microorganisms = false, advancedCiv = false,
            strawberry = false, mithril = false;
    
    private byte modules = 4;

    private PropertyChangeSupport propertySupportHRACE;
    private VetoableChangeSupport vetoableSupportHRACE;

    public SpaceStation() {
        propertySupportHRACE = new PropertyChangeSupport(this);
        vetoableSupportHRACE = new VetoableChangeSupport(this);
    }

    //SETTERS
    public void SetAcidRain() throws PropertyVetoException {
        modules -= 1;
        if (modules >= 2) {
            System.out.println("\nHRACE TO OTAN: *%**@#~€**¬#**G**~23~@¬€*R**R**!\n"
                    + "************************************************\n"
                    + "DUE TO ACID RAIN, WE HAVE LOST 1 PERIFERICAL MODULE.\n"
                    + "NOW WE HAVE " + modules + ", DO NOT INFORM SPACE AGENCIES OF THIS!\n");
            boolean oldAcidRain = GetAcidRain();
            //Inverts the original state, now it's raining (true).
            acidRain = !acidRain;
            boolean newAcidRain = acidRain;

            propertySupportHRACE.firePropertyChange(PROP_RAIN, oldAcidRain, newAcidRain);
            //Back to original state.
            acidRain = !acidRain;
        } else {
            vetoableSupportHRACE.fireVetoableChange(PROP_RAIN, 0, modules);
        }

    }

    public void SetCyclons() {
        System.out.print("\n********************************************");
        System.out.println("\nHRACE TO OTAN: *%**D~@77HHWFUOZ@**J·/!¬~@**!\n"
                + "********************************************");
        boolean oldCyclon = GetCyclons();
        cyclonF10 = !cyclonF10;
        boolean newCyclon = cyclonF10;

        propertySupportHRACE.firePropertyChange(PROP_CYCLON, oldCyclon, newCyclon);

        cyclonF10 = !cyclonF10;
    }

    public void SetMicroorganisms() {
        System.out.print("\n**********************************");
        System.out.println("\nHRACE TO OTAN: *%**@#UOLIPBH8Q6JK**34J·/!¬~@**!\n"
                + "**********************************");
        boolean oldMicroorganisms = GetMicroorganisms();
        microorganisms = !microorganisms;
        boolean newMicroorganisms = microorganisms;

        propertySupportHRACE.firePropertyChange(PROP_MICROSCOPIC_LIFE, oldMicroorganisms,
                newMicroorganisms);

        microorganisms = !microorganisms;
    }

    public void SetAdvancedCiv() throws PropertyVetoException {
        if (GetModules() >= 2) {
            System.out.print("\n**********************************");
            System.out.println("\nHRACE TO OTAN: *%**@**J~#~¬RH·/!¬~@**!J46UH4Wn"
                    + "**********************************");
            boolean oldAdvancedCiv = GetAdvancedCiv();
            advancedCiv = !advancedCiv;
            boolean newAdvancedCiv = advancedCiv;
            
            propertySupportHRACE.firePropertyChange(PROP_AV_CIV, oldAdvancedCiv,
                    newAdvancedCiv);

            advancedCiv = !advancedCiv;
        }
        else
            vetoableSupportHRACE.fireVetoableChange(PROP_AV_CIV, 0, GetModules());
    }

    public void SetStrawberry() {
        System.out.print("\n**********************************");
        System.out.println("\nHRACE TO OTAN: *%ERYHR€~€~€~€EVYU57B/!¬~@**!\n"
                + "**********************************");
        boolean oldStrawberry = GetStrawberry();
        strawberry = !strawberry;
        boolean newStrawberry = strawberry;

        propertySupportHRACE.firePropertyChange(PROP_STRAWBERRY, oldStrawberry,
                newStrawberry);

        strawberry = !strawberry;
    }

    public void SetMithril() {
        System.out.print("\n*********************************************");
        System.out.println("\nHRACE TO OTAN: *%**@*~HG~66W8OK83*JYIL¬~G@**!\n"
                + "*********************************************");
        boolean oldMithril = GetMithril();
        mithril = !mithril;
        boolean newMithril = mithril;

        propertySupportHRACE.firePropertyChange(PROP_MITHRIL, oldMithril,
                newMithril);

        mithril = !mithril;
    }

    //Listeners
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupportHRACE.addPropertyChangeListener(listener);
    }

    public void remPropertyChangeListener(PropertyChangeListener listener) {
        propertySupportHRACE.removePropertyChangeListener(listener);
    }

    public void addVetoChangeListener(VetoableChangeListener listener) {
        vetoableSupportHRACE.addVetoableChangeListener(listener);
    }

    public void remVetoChangeListener(VetoableChangeListener listener) {
        vetoableSupportHRACE.addVetoableChangeListener(listener);
    }

    //Getters
    public boolean GetAcidRain() {
        return acidRain;
    }

    public boolean GetCyclons() {
        return cyclonF10;
    }

    public boolean GetMicroorganisms() {
        return microorganisms;
    }

    public boolean GetAdvancedCiv() {
        return advancedCiv;
    }

    public boolean GetStrawberry() {
        return strawberry;
    }

    public boolean GetMithril() {
        return mithril;
    }

    public byte GetModules() {
        return modules;
    }

}
