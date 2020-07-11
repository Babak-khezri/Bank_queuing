package nobat_dehi_bank;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Customer {

    public void Variz(int vajh, int mojodi_baje, int numThread) {
        mojodi_baje = mojodi_baje + vajh;
        switch (numThread) {
            case 1:
                Opration.mojodi_baje_1 = mojodi_baje;
                break;
            case 2:
                Opration.mojodi_baje_2 = mojodi_baje;
                break;
            case 3:
                Opration.mojodi_baje_3 = mojodi_baje;
                break;
        }
    }

    public void Bardasht(int vajh, int mojodi_baje, int mojoodi_sandugh, int numThread) {
        if (vajh > mojodi_baje) {
            if(mojoodi_sandugh >= 50000)
                try {
                    mojoodi_sandugh -= 50000; // kahesh pol sandogh
                    Opration.MOJOODI = mojoodi_sandugh; // nashan dadn pol sandogh jadid
                    mojodi_baje = mojodi_baje + 50000; // afzaish pol sandogh
                    Thread.sleep(1500); // just to show the text
                    mojodi_baje = mojodi_baje - vajh;
                } catch (InterruptedException ex) {
                    Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
                }
            else{
                mojoodi_sandugh += (Opration.mojodi_baje_1 + Opration.mojodi_baje_2 + Opration.mojodi_baje_3);
                Opration.mojodi_baje_1 = 0;
                Opration.mojodi_baje_2 = 0;
                Opration.mojodi_baje_3 = 0;
                try {
                    mojoodi_sandugh -= 50000; // kahesh pol sandogh
                    Opration.MOJOODI = mojoodi_sandugh; // nashan dadn pol sandogh jadid
                    mojodi_baje = mojodi_baje + 50000; // afzaish pol sandogh
                    Thread.sleep(1500); // just to show the text
                    mojodi_baje = mojodi_baje - vajh;
                } catch (InterruptedException ex) {
                    Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            mojodi_baje = mojodi_baje - vajh;
        }
        switch (numThread) {
            case 1:
                Opration.mojodi_baje_1 = mojodi_baje;
                break;
            case 2:
                Opration.mojodi_baje_2 = mojodi_baje;
                break;
            case 3:
                Opration.mojodi_baje_3 = mojodi_baje;
                break;
        }
    }
}