package LowLevelDesign.Design_Payment_Gateway.User;

import LowLevelDesign.Design_Payment_Gateway.Instrument.Instrument;
import LowLevelDesign.Design_Payment_Gateway.Instrument.InstrumentDo;

public class UserDo {

    int userId;
    String name;
    String email;
    String phone;
    public InstrumentDo instrument;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
