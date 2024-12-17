/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.sql.Date;

/**
 *
 * @author EndUser
 */
public class reservation {
    
    String username,email,item;
    Date start_date,end_date;

  //  public String getUsername() {
    //    return username;
   // }

 //   public void setUsername(String username) {
   //     this.username = username;
   // }

  //  public String getEmail() {
  //      return email;
  //  }

  //  public void setEmail(String email) {
   //     this.email = email;
   // }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }
    
    
    
}
