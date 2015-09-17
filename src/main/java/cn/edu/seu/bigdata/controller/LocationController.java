/************************************************************************************ 
 All rights are reserved. Reproduction or transmission in whole or in part锛�in  <br> 
 any form or by any means锛�electronic锛�mechanical or otherwise锛�is prohibited  <br> 
 without the prior written consent of the copyright owner                        <br> 
 *************************************************************************************/

/**
 * File Name锛歀ocationController.java<br>
 * Copyright锛欳opyright by ZTEsoft<br>
 * Description锛欶ile Description	<br>
 * Author锛欰dministrator<br>
 * Create Date锛�015骞�鏈�2鏃�br>
 * Task ID锛�<br>
 * Modifier锛欰dministrator<br>
 * Modified Date锛�015骞�鏈�2鏃�br>
 * Modified Content:<br>
 */

package cn.edu.seu.bigdata.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import cn.edu.seu.bigdata.service.ActService;
import cn.edu.seu.bigdata.service.LocationService;
import cn.edu.seu.bigdata.service.UserManageService;
import cn.edu.seu.bigdata.bean.Location;
import cn.edu.seu.bigdata.bean.User;




/** 
 * <Description> <br> 
 *  
 * @author Administrator <br>
 * @version <br>
 * @CreateDate 2015骞�鏈�2鏃�<br>
 * @see cn.edu.seu.bigdata.controller <br>
 * @since <br>
 */


@Controller
@RequestMapping("/location")
public class LocationController {
    
    private LocationService locationService;
	private ActService actService;
	private UserManageService userService;

    @Autowired
    public void setLocationService(LocationService locationService) {
        this.locationService =locationService;
    }
    @Autowired
    public void setActService(ActService actService) {
        this.actService =actService;
    }
    
    @Autowired
    public void setUserService(UserManageService userService) {
        this.userService =userService;
    }
    
     
    @RequestMapping(path="/loc",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Location> create(@RequestBody String location){
    	
    	double lat;
    	double lng;
    	int userid;
    	String poi;
    	String address;
    	String loca="[";
    	
    	
    	String [] loco = location.split(",");
    	String [] spl=loco[0].split(":");
    	lat = Double.valueOf(spl[1]);
    	spl = loco[1].split(":");
    	lng = Double.valueOf(spl[1]);
    	spl = loco[2].split(":");
   
    	userid = Integer.valueOf(spl[1].substring(1, spl[1].length()-1));
    	spl = loco[3].split(":");
    	poi = spl[1].substring(1, spl[1].length()-1);
    	spl = loco[4].split(":");
    	address = spl[1].substring(1, spl[1].length()-2);
    		
    	Location locations = locationService.qryLocationByAddress(address,poi);
    	if (locations == null){
    		locations = locationService.saveLocationBaiDu(lat, lng, poi, address);
    	}
    	
    	actService.saveAct(userid, locations.getId());   
    	
    	List<Location> locate = locationService.getNearbyLocation(lat, lng,1000);
    	
    	for (int i=0;i<locate.size()-1;i++)
    	{
    		loca = loca + "{"+"\"lat\":\""+locate.get(i).getLat()+"\",";
    		loca = loca + "\"lng\":\""+locate.get(i).getLng()+"\""+"},";
    		List<User> user = locationService.getNearbyUser(locate.get(i).getId());
    		if (user.size()==0)
    			locate.remove(i);
    		
    	}
    	loca = loca + "{"+"\"lat\":\""+locate.get(locate.size()-1).getLat()+"\",";
		loca = loca + "\"lng\":\""+locate.get(locate.size()-1).getLng()+"\""+"}";
    	
    	loca = loca + "]";
    	return locate;
    	
    }

    @RequestMapping(path="/interest",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<Integer, List<Location>> showInterest(@RequestBody String userid){
    String[] str = userid.split(":");    
    str[1]=str[1].substring(1, str[1].length()-2);
    System.out.print("*************"+str[1]);
    int user_id = Integer.parseInt(str[1]);
    User user = userService.findUserByID(user_id);
    Map<Integer,List<Location> > mappedLocations = new HashMap<Integer, List<Location>>();
    Map<Integer,List<Location> > mappedLocation = new HashMap<Integer, List<Location>>();
    
    String[] tag =  user.getTag().split(",");
    List<Location> loc= new ArrayList<Location>();
    List <User> users = userService.getAllUSer();
    for (int i=0;i<=10;i++)
    {
    	mappedLocations.put(i, loc);
    }
    
    int count;
    if (users.size()!=0){
    	
    
    for (int i=0;i<users.size();i++)
    {
    	count=0;
    	String[] tagQry = users.get(i).getTag().split(",");
    	for (int j=0;j<10;j++)
    	{
    		if ((tag[j].equals(tagQry[j]))&&(tag[j].equals("1")))
    			count++;
    	}
    	if ( count!=0 )
    	{
    		loc = mappedLocations.get(count);
    		if (users.get(i).getLocation().size()!=0 && loc!=null)
    		{
       		loc.removeAll(users.get(i).getLocation());
    		loc.addAll(users.get(i).getLocation());
    		}
    		mappedLocations.put(count, loc);
    		
    	}
    }
    }
    
    	
    	List<Location> location = locationService.getNearbyLocation(31.892653, 118.835167, 1000);
    	List<Location> location1 = locationService.getNearbyLocation(39.881897, 116.454453, 1000);
    	
    	mappedLocation.put(2, location);
    	mappedLocation.put(3, location1);
    	
    	
       	
		return mappedLocation;
    	
    	
    	
    }
    

    

}
