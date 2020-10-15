package check;

public class Check {
    public boolean checkPhone(String value) {
        String regex = "^0[0-9]{9}$";
        return value.matches(regex);
    }
    public boolean checkEmail(String value) {
        String regex = "[a-zA-Z0-9]*@[a-zA-Z]*.com";
        return value.matches(regex);
    }
}
