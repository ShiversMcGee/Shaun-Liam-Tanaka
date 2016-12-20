/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enumerations;

/**
 *
 * @author Tanaka
 */
public enum StaffType {
    admin,
    regular,
    service;
    
    @Override
    public String toString()
    {
        String strResult = "";
        switch (this)
        {
            case admin:
                strResult = "admin";
                break;
            case regular:
                strResult = "regular";
                break;
            case service:
                strResult = "service";
                break;
        }
        return strResult;
    }
}

