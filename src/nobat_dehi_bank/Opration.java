package nobat_dehi_bank;

import java.awt.Color;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Opration {
    JTextField lbl_nb1, lbl_nb2, lbl_nb3, lbl_nb4;
    JLabel lbl_mb1, lbl_mb2, lbl_mb3, lbl_mojoodi;
    JLabel lbl_op1, lbl_op2, lbl_op3;
    Customer customer;

    public Opration(JTextField lblnb1, JTextField lblnb2, JTextField lblnb3,
            JLabel lblmb1, JLabel lblmb2, JLabel lblmb3,
            JLabel lblop1, JLabel lblop2, JLabel lblop3, JLabel lbl_mojoodi) {
        customer = new Customer();
        this.lbl_nb1 = lblnb1; // shomare moshtri
        this.lbl_nb2 = lblnb2; // shomare moshtri
        this.lbl_nb3 = lblnb3; // shomare moshtri

        this.lbl_mb1 = lblmb1; // mojodi_baje
        this.lbl_mb2 = lblmb2; // mojodi_baje
        this.lbl_mb3 = lblmb3; // mojodi_baje

        this.lbl_op1 = lblop1; // kar moshtari
        this.lbl_op2 = lblop2; // kar moshtari
        this.lbl_op3 = lblop3; // kar moshtari
        this.lbl_mojoodi = lbl_mojoodi; // mojodi kol
    }

    Timer timer, t1, t2, t3;
    TimerTask timerTask, tt1, tt2, tt3;
    public static int MOJOODI = 500000;

    public int VARIZ = 1;
    public int BARDASHT = 2;
    public int nobat = 1;
    public int shomare = 1;

    public static int mojodi_baje_1, mojodi_baje_2, mojodi_baje_3;
    int check_nobat;
    int rand;

    public void daryaft_nobat(JTextField jtxtField) {
        timer = new Timer();

        timerTask = new TimerTask() {
            @Override
            public void run() {
                ++shomare;
                jtxtField.setText(String.valueOf(shomare));
            }
        };
        timer.schedule(timerTask, 100, 10000); //for ever after 10 sec calls the timerTast function
    }

    public void sequencer() { // barrsi nobat va check krdn baje ha

        t1 = new Timer(); // Create timer for call timerTask for ever
        tt1 = new TimerTask() {
            @Override
            public void run() {
                if (nobat < shomare && check_nobat != nobat) {
                    lbl_nb1.setText(String.valueOf(nobat));
                    check_nobat = nobat;
                    ++nobat;
                    oprate(mojodi_baje_1, lbl_op1, 1);
                    lbl_mb1.setText(String.valueOf(mojodi_baje_1));
                    lbl_mojoodi.setText(String.valueOf(MOJOODI));
                    rand = delay_customer();
                    try {
                        Thread.sleep(rand);
                    } catch (InterruptedException e) {
                    }
                }
            }
        };
        t1.schedule(tt1, 200, 7000);
        t2 = new Timer();
        tt2 = new TimerTask() {
            @Override
            public void run() {

                if (nobat < shomare && check_nobat != nobat) {
                    lbl_nb2.setText(String.valueOf(nobat));
                    check_nobat = nobat;
                    ++nobat;
                    oprate(mojodi_baje_2, lbl_op2, 2);
                    lbl_mb2.setText(String.valueOf(mojodi_baje_2));
                    lbl_mojoodi.setText(String.valueOf(MOJOODI));
                    rand = delay_customer();
                    try {
                        Thread.sleep(rand);
                    } catch (InterruptedException e) {
                    }

                }
            }
        };

        t2.schedule(tt2, 300, 7000);
        t3 = new Timer();
        tt3 = new TimerTask() {
            @Override
            public void run() {

                if (nobat < shomare && check_nobat != nobat) {
                    lbl_nb3.setText(String.valueOf(nobat));
                    check_nobat = nobat;
                    ++nobat;
                    oprate(mojodi_baje_3, lbl_op3, 3);

                    lbl_mb3.setText(String.valueOf(mojodi_baje_3));
                    lbl_mojoodi.setText(String.valueOf(MOJOODI));
                    rand = delay_customer();
                    try {
                        Thread.sleep(rand);
                    } catch (InterruptedException e) {
                    }
                }
            }
        };
        t3.schedule(tt3, 400, 6000);
    }

    public void oprate(int mojodi_baje, JLabel lbl_oprate, int numThread) {
        int vajh = make_vahj(); // sakht vajh random
        
        Random random = new Random();
        int job = random.nextInt(2); // taien kardn kar moshtari 1 == variz va 2 == bardasht
 
        if (job == VARIZ) { // job == 1
            lbl_oprate.setText("واریز" + " " + vajh);
            lbl_oprate.setBackground(Color.red);
            customer.Variz(vajh, mojodi_baje, numThread);

        } else { //job == 2
            lbl_oprate.setText("برداشت" + " " + vajh);
            lbl_oprate.setBackground(Color.BLUE);
            if (vajh > mojodi_baje) {
                String str = "درحال دریافت پول...";
                switch (numThread) {
                    case 1:
                        lbl_mb1.setText(str);
                        break;

                    case 2:
                        lbl_mb2.setText(str);
                        break;

                    case 3:
                        lbl_mb3.setText(str);
                        break;
                }
            }
            customer.Bardasht(vajh, mojodi_baje, MOJOODI, numThread);
        }
    }

    public int make_vahj() { // make a random money between 1000 _ 10000
        Random random = new Random();
        String vajh = String.valueOf(random.nextInt(48) + 1);
        vajh += "000";
        return Integer.parseInt(vajh);
    }

    public int delay_customer() { // zman tama shodan kar bin 5 ta 80 sanie
        Random random = new Random();
        String time = String.valueOf(random.nextInt(75)+5);
        time += "000";
        return Integer.parseInt(time);
    }
}