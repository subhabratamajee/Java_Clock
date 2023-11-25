import javax.swing.*;
import java.util.Calendar;
import java.awt.*;

public class MyClock extends Thread {
    private static JFrame fr;
    private static JLabel ct;
    private static JLabel date;
    private Calendar cal;
    private int hr, min, sec, am_pm;
    private String s;
    private int dayOfWeek, year, month, day;
    private String months[] = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
    private String days[] = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };

    MyClock() {
        start();
    }

    public void run() {
        try {
            while (true) {
                Thread.sleep(100);
                cal = Calendar.getInstance();

                // time
                hr = cal.get(Calendar.HOUR);
                min = cal.get(Calendar.MINUTE);
                sec = cal.get(Calendar.SECOND);
                am_pm = cal.get(Calendar.AM_PM);

                // date
                dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
                day = cal.get(Calendar.DAY_OF_MONTH);
                month = cal.get(Calendar.MONTH);
                year = cal.get(Calendar.YEAR);
                if (am_pm == 0)
                    s = "AM";
                else
                    s = "PM";
                ct.setText("Current Time :" + hr + ":" + min + ":" + sec + " " + s);
                date.setText(days[dayOfWeek - 1] + ", " + day + " " + months[month] + " " + year);
                ct.setVisible(true);
                date.setVisible(true);

            }
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) {
        fr = new JFrame("Time");
        fr.setBounds(600, 100, 500, 200);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel p = new JPanel();
        p.setLayout(null);
        ct = new JLabel("Current Time:");
        ct.setFont(new Font("Helvetica", Font.BOLD, 35));
        ct.setForeground(Color.BLACK);
        ct.setBounds(10, 10, 480, 60);
        p.add(ct);
        date = new JLabel("date");
        date.setFont(new Font("Helvetica", Font.BOLD, 31));
        date.setForeground(Color.DARK_GRAY);
        date.setBounds(10, 70, 480, 60);
        p.add(date);
        fr.getContentPane().add(p);
        fr.setVisible(true);
        new MyClock();
    }
}
