package org.byby;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.byby.jna.WindowSetDateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.regex.Pattern;

public class Controller {
    @FXML
    Button goButton;

    @FXML
    TextField hour;

    @FXML
    TextField minute;

    @FXML
    TextField month;

    @FXML
    TextField day;

    @FXML
    CheckBox isSetDay;

    @FXML
    Label result;

    @FXML
    public void initialize() {
        LocalDateTime now = LocalDateTime.now();
        month.setText(String.valueOf(now.getMonthValue()));
        day.setText(String.valueOf(now.getDayOfMonth()));
        hour.setText(String.valueOf(now.getHour()));
        minute.setText(String.valueOf(now.getMinute()));
    }

    @FXML
    public void click(ActionEvent event) {
        String sHour = hour.getText();
        String sMinute = minute.getText();
        String sDay = day.getText();
        String sMonth = month.getText();
        if (!isDigital(sHour) ||
                !isDigital(sMinute) ||
                !isDigital(sDay) ||
                !isDigital(sMonth)) {
            result.setText("Wrong data");
            return;
        }

        short hour = Short.parseShort(sHour);
        short minute = Short.parseShort(sMinute);
        short day = Short.parseShort(sDay);
        short month = Short.parseShort(sMonth);

        new WindowSetDateTime().SetLocalTime((short) LocalDate.now().getYear(),
                month,
                day,
                hour,
                minute,
                (short) 0);

        result.setText("Success! Hour: " + sHour + " minute: " + sMinute);
    }

    @FXML
    public void setDayClick(ActionEvent event) {
        month.setDisable(!isSetDay.isSelected());
        day.setDisable(!isSetDay.isSelected());
    }

    private static boolean isDigital(String string) {
        String regex = "[0-9]+";
        return Pattern.matches(regex, string);
    }

}
