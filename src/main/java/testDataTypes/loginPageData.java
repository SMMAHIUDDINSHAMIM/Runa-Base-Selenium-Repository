//-----------------------------------testDataResources.Address.java-----------------------------------

package testDataTypes;

public class loginPageData {
    // public String dataType;
    // public Eligibility eligibility;
    // public ContactInfo contactInfo;
    // public Address address;  
   


    
    public class Eligibility {
        public String firstName;
        public String mI;
        public String lastName;
        public String suffix;
        public String dOB;
        public String sSN;           
    }

    public class ContactInfo {

        public String email;
        public String mobile;
        public String home;

    }
    
    public class Address {

        public Home home;
        public Mailing mailing;
        public Work work;

    }
 
    public class Home {

        public String streetAddress;
        public String city;
        public String state;
        public String zip;

    }
  
    
}