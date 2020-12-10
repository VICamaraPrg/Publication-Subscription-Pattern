package Main;

import SubscriptorObject.*;
import IntermediaryObject.OTAN;
import ObservedObject.SpaceStation;
import java.beans.PropertyVetoException;
import java.util.Scanner;

public class HRACEPublicationSubscriiption {

    public static void main(String[] args) throws PropertyVetoException {
        OTAN o = new OTAN();
        SpaceStation HRACE = new SpaceStation();
        Roscosmos rus = new Roscosmos("Roscosmos", 0);
        NASA usa = new NASA("NASA", 0);
        CNSA prc = new CNSA("CNSA", 0);
        APS pa = new APS("APS", 0);
        Scanner readKeys = new Scanner(System.in);

        boolean end = false;

        //OTAN LISTENS FOR EVENTS IN HRACE
        HRACE.addPropertyChangeListener(o);
        HRACE.addVetoChangeListener(o);

        //PROP CHANGE
        //ALL AGENCIES LISTENS TO OTAN FOR EVENTS.
        o.addPropertyChangeListener(usa);
        o.addPropertyChangeListener(rus);
        o.addPropertyChangeListener(prc);
        o.addPropertyChangeListener(pa);

        //VETO
        //ALL AGENCIES LISTENS FOR VETO CHANGES.
        o.addVetoChangeListener(usa);
        o.addVetoChangeListener(rus);
        o.addVetoChangeListener(prc);
        o.addVetoChangeListener(pa);

        while (!end) {

            Menu.ShowMenu();
            byte option = readKeys.nextByte();

            switch (option) {

                case 1:
                    try {
                    HRACE.SetAcidRain();
                } catch (PropertyVetoException pve) {
                    System.out.println(pve.getMessage());
                }

                break;

                case 2:
                    HRACE.SetCyclons();
                    break;

                case 3:
                    HRACE.SetMicroorganisms();
                    break;

                case 4:
                try {
                    HRACE.SetAdvancedCiv();
                    if (HRACE.GetModules() >= 2) {
                        end = !end;
                        break;
                    }

                } catch (PropertyVetoException pve) {
                    System.out.println(pve.getMessage());
                }
                break;

                case 5:
                    HRACE.SetStrawberry();
                    break;

                case 6:
                    HRACE.SetMithril();
                    break;
            }

            if (rus.GetBudget() >= 50) {
                end = !end;
                rus.EnoughBudget();

            }
            if (usa.GetBudget() >= 50) {
                end = !end;
                usa.EnoughBudget();

            }
            if (prc.GetBudget() >= 50) {
                end = !end;
                prc.EnoughBudget();

            }
            if (pa.GetBudget() >= 50) {
                end = !end;
                pa.EnoughBudget();

            }

        }
    }
}
