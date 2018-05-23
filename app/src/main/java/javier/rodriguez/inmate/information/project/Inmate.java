package javier.rodriguez.inmate.information.project;

/**
 * Created by javier on 5/23/18.
 */

public class Inmate {
    private String facility_ID;
    private String id;
    private String first_Name;
    private String last_Name;
    private String pod;
    private String uid;

    ////////////////////////////////////////////
    //FUNCTION NAME: InmateList               //
    //FUNCTION PURPOSE: constructor.          //
    //                                        //
    //PARAMETERS: 1 - String                  //
    //            2 - String                  //
    //            3 - String                  //
    //            4 - String                  //
    //            5 - String                  //
    //            6 - String                  //
    //RETURNS: Object.                        //
    ////////////////////////////////////////////
    //CREATED BY: Javier Rodriguez.           //
    //DATE:05/23/2018                         //
    ////////////////////////////////////////////
    //LAST MODIFICATION:                      //
    //MADE BY:                                //
    ////////////////////////////////////////////
    public Inmate(String facility_ID, String inmate_ID, String inmate_First_Name, String inmate_Last_Name,
                  String inmate_Pod, String inmate_Uid){
        this.facility_ID = facility_ID;
        this.id = inmate_ID;
        this.first_Name = inmate_First_Name;
        this.last_Name = inmate_Last_Name;
        this.pod = inmate_Pod;
        this.uid = inmate_Uid;
    }

    ////////////////////////////////////////////
    //FUNCTION NAME: getFacilityID            //
    //FUNCTION PURPOSE: getter                //
    //                                        //
    //PARAMETERS: 1 - String                  //
    //RETURN: String                          //
    ////////////////////////////////////////////
    //CREATED BY: Javier Rodriguez.           //
    //DATE:05/23/2018                         //
    ////////////////////////////////////////////
    //LAST MODIFICATION:                      //
    //MADE BY:                                //
    ////////////////////////////////////////////
    public String getFacilityID(){return facility_ID;}

    ////////////////////////////////////////////
    //FUNCTION NAME: getInmateID              //
    //FUNCTION PURPOSE: getter                //
    //                                        //
    //PARAMETERS: 1 - String                  //
    //RETURN: String                          //
    ////////////////////////////////////////////
    //CREATED BY: Javier Rodriguez.           //
    //DATE:05/23/2018                         //
    ////////////////////////////////////////////
    //LAST MODIFICATION:                      //
    //MADE BY:                                //
    ////////////////////////////////////////////
    public String getInmateID(){return id;}

    ////////////////////////////////////////////
    //FUNCTION NAME: getInmateFirstName       //
    //FUNCTION PURPOSE: getter                //
    //                                        //
    //PARAMETERS: 1 - String                  //
    //RETURN: String                          //
    ////////////////////////////////////////////
    //CREATED BY: Javier Rodriguez.           //
    //DATE:05/23/2018                         //
    ////////////////////////////////////////////
    //LAST MODIFICATION:                      //
    //MADE BY:                                //
    ////////////////////////////////////////////
    public String getInmateFirstName(){return first_Name;}

    ////////////////////////////////////////////
    //FUNCTION NAME: getInmateLastName        //
    //FUNCTION PURPOSE: getter                //
    //                                        //
    //PARAMETERS: 1 - String                  //
    //RETURN: String                          //
    ////////////////////////////////////////////
    //CREATED BY: Javier Rodriguez.           //
    //DATE:05/23/2018                         //
    ////////////////////////////////////////////
    //LAST MODIFICATION:                      //
    //MADE BY:                                //
    ////////////////////////////////////////////
    public String getInmateLastName(){return last_Name;}

    ////////////////////////////////////////////
    //FUNCTION NAME: getInmatePod             //
    //FUNCTION PURPOSE: getter                //
    //                                        //
    //PARAMETERS: 1 - String                  //
    //RETURN: String                          //
    ////////////////////////////////////////////
    //CREATED BY: Javier Rodriguez.           //
    //DATE:05/23/2018                         //
    ////////////////////////////////////////////
    //LAST MODIFICATION:                      //
    //MADE BY:                                //
    ////////////////////////////////////////////
    public String getInmatePod(){return pod;}

    ////////////////////////////////////////////
    //FUNCTION NAME: getInmateUid             //
    //FUNCTION PURPOSE: getter                //
    //                                        //
    //PARAMETERS: 1 - String                  //
    //RETURN: String                          //
    ////////////////////////////////////////////
    //CREATED BY: Javier Rodriguez.           //
    //DATE:05/23/2018                         //
    ////////////////////////////////////////////
    //LAST MODIFICATION:                      //
    //MADE BY:                                //
    ////////////////////////////////////////////
    public String getInmateUid(){return uid;}

    ////////////////////////////////////////////
    //FUNCTION NAME: setFacilityId            //
    //FUNCTION PURPOSE: setter                //
    //                                        //
    //PARAMETERS: 1 - String                  //
    //RETURN: Void                            //
    ////////////////////////////////////////////
    //CREATED BY: Javier Rodriguez.           //
    //DATE:05/23/2018                         //
    ////////////////////////////////////////////
    //LAST MODIFICATION:                      //
    //MADE BY:                                //
    ////////////////////////////////////////////
    public void setFacilityID(String facility_ID){
        this.facility_ID = facility_ID;
    }

    ////////////////////////////////////////////
    //FUNCTION NAME: setInmateId              //
    //FUNCTION PURPOSE: setter                //
    //                                        //
    //PARAMETERS: 1 - String                  //
    //RETURN: Void                            //
    ////////////////////////////////////////////
    //CREATED BY: Javier Rodriguez.           //
    //DATE:05/23/2018                         //
    ////////////////////////////////////////////
    //LAST MODIFICATION:                      //
    //MADE BY:                                //
    ////////////////////////////////////////////
    public void setInmateID(String inmate_ID){
        this.id = inmate_ID;
    }

    ////////////////////////////////////////////
    //FUNCTION NAME: setInmateFirstName       //
    //FUNCTION PURPOSE: setter                //
    //                                        //
    //PARAMETERS: 1 - String                  //
    //RETURN: Void                            //
    ////////////////////////////////////////////
    //CREATED BY: Javier Rodriguez.           //
    //DATE:05/23/2018                         //
    ////////////////////////////////////////////
    //LAST MODIFICATION:                      //
    //MADE BY:                                //
    ////////////////////////////////////////////
    public void setInmateFirstName(String inmateFirstName){
        this.first_Name = inmateFirstName;
    }

    ////////////////////////////////////////////
    //FUNCTION NAME: setInmateLastName        //
    //FUNCTION PURPOSE: setter                //
    //                                        //
    //PARAMETERS: 1 - String                  //
    //RETURN: Void                            //
    ////////////////////////////////////////////
    //CREATED BY: Javier Rodriguez.           //
    //DATE:05/23/2018                         //
    ////////////////////////////////////////////
    //LAST MODIFICATION:                      //
    //MADE BY:                                //
    ////////////////////////////////////////////
    public void setInmateLastName(String inmateLastName){
        this.last_Name = inmateLastName;
    }

    ////////////////////////////////////////////
    //FUNCTION NAME: setInmatePOd             //
    //FUNCTION PURPOSE: setter                //
    //                                        //
    //PARAMETERS: 1 - String                  //
    //RETURN: Void                            //
    ////////////////////////////////////////////
    //CREATED BY: Javier Rodriguez.           //
    //DATE:05/23/2018                         //
    ////////////////////////////////////////////
    //LAST MODIFICATION:                      //
    //MADE BY:                                //
    ////////////////////////////////////////////
    public void setInmatePod(String inmatePod){
        this.pod = inmatePod;
    }

    ////////////////////////////////////////////
    //FUNCTION NAME: setInmateUid             //
    //FUNCTION PURPOSE: setter                //
    //                                        //
    //PARAMETERS: 1 - String                  //
    //RETURN: Void                            //
    ////////////////////////////////////////////
    //CREATED BY: Javier Rodriguez.           //
    //DATE:05/23/2018                         //
    ////////////////////////////////////////////
    //LAST MODIFICATION:                      //
    //MADE BY:                                //
    ////////////////////////////////////////////
    public void setInmateUid(String inmateUid){
        this.uid = inmateUid;
    }
}