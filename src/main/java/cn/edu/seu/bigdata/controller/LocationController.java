/************************************************************************************ 
 All rights are reserved. Reproduction or transmission in whole or in part， in  <br> 
 any form or by any means， electronic， mechanical or otherwise， is prohibited  <br> 
 without the prior written consent of the copyright owner                        <br> 
 *************************************************************************************/

/**
 * File Name：LocationController.java<br>
 * Copyright：Copyright by ZTEsoft<br>
 * Description：File Description	<br>
 * Author：Administrator<br>
 * Create Date：2015年9月12日<br>
 * Task ID：	<br>
 * Modifier：Administrator<br>
 * Modified Date：2015年9月12日<br>
 * Modified Content:<br>
 */

package cn.edu.seu.bigdata.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.seu.bigdata.service.LocationService;
import cn.edu.seu.bigdata.service.UserManageService;
import cn.edu.seu.bigdata.bean.Location;




/** 
 * <Description> <br> 
 *  
 * @author Administrator <br>
 * @version <br>
 * @CreateDate 2015年9月12日 <br>
 * @see cn.edu.seu.bigdata.controller <br>
 * @since <br>
 */


@Controller
@RequestMapping("/location")
public class LocationController {
    
    private LocationService locationService;

    @Autowired
    public void setUserService(LocationService locationService) {
        this.locationService =locationService;
    }
    
    

    
    
    @RequestMapping(path="/loc",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Location create(@RequestBody Location location){

        System.out.println(location.getLat());
       
        double lat = location.getLat();
        double lng = location.getLng();
        String poi = location.getPoi();
       
        String address = location.getAddress();
        locationService.saveLocationBaiDu(lat, lng, poi, address);
        return location;
    }
    

}
