
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;


@ResultPath(value = "/loginAction")
@Action(value = "loginAction", results = {
        @Result(name = "success", location = "LoginAction"),
        @Result(name = "input", location = "index.jsp"),
        
})
public class LoginForm extends ActionSupport {

    private String name;
    private String mobileNumber;
    private String email;

    // Getters and setters for properties

    @Override
    public String execute() {
        // Perform validations
        if (name == null || name.isEmpty() || mobileNumber ==null || email ==null) {
            addActionError("Name is required.");
            return INPUT;
        }
        
        // Add other validations (mobile, email, etc.)

        // If all validations pass, redirect to welcome page
        return SUCCESS;
    }
}
