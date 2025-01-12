package com.lab.util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
*
数据列表解释器，键值对列举说明工具，例如性别字段：1表示男，2表示女
*
*/
public class DataListUtils {
	public static void main(String[] args) {
	}
	/**
	**获取登录角色列表
	*/
	public static List<Map<String,Object>> getLoginTypeList(){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		list.add(getMap("1","admin"));
		list.add(getMap("2","manage"));
		list.add(getMap("3","teacher"));
		list.add(getMap("4","student"));
		return list;
	}
	/**
	**获取sex数据列表
	*/
	public static List<Map<String,Object>> getSexList(){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		list.add(getMap("1","男"));
		list.add(getMap("2","女"));
		return list;
	}
	public static String getSexNameById(String id){//根据sex的key值获取名称
		List<Map<String,Object>> list = getSexList();
		return getNameById(id,list);
	}
	/**
	**获取stu_type数据列表
	*/
	public static List<Map<String,Object>> getStuTypeList(){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		list.add(getMap("1","研究生"));
		list.add(getMap("2","本科生"));
		return list;
	}
	public static String getStuTypeNameById(String id){//根据stu_type的key值获取名称
		List<Map<String,Object>> list = getStuTypeList();
		return getNameById(id,list);
	}
	/**
	**获取room_type数据列表
	*/
	public static List<Map<String,Object>> getRoomTypeList(){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		list.add(getMap("1","仅教师可预约"));
		list.add(getMap("2","全部都可预约"));
		return list;
	}
	public static String getRoomTypeNameById(String id){//根据room_type的key值获取名称
		List<Map<String,Object>> list = getRoomTypeList();
		return getNameById(id,list);
	}
	/**
	**获取order_time数据列表
	*/
	public static List<Map<String,Object>> getOrderTimeList(){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		list.add(getMap("1","8.00-9.40"));
		list.add(getMap("2","10.00-11.40"));
		list.add(getMap("3","14.00-15.40"));
		list.add(getMap("4","16.00-17.40"));
		list.add(getMap("5","19.00-20.40"));
		return list;
	}
	public static String getOrderTimeNameById(String id){//根据order_time的key值获取名称
		List<Map<String,Object>> list = getOrderTimeList();
		return getNameById(id,list);
	}
	/**
	**获取order_status数据列表
	*/
	public static List<Map<String,Object>> getOrderStatusList(){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		list.add(getMap("1","已申请预约"));
		list.add(getMap("2","已接受预约"));
		list.add(getMap("3","已拒绝预约"));
		list.add(getMap("4","已取消预约"));
		return list;
	}
	public static String getOrderStatusNameById(String id){//根据order_status的key值获取名称
		List<Map<String,Object>> list = getOrderStatusList();
		return getNameById(id,list);
	}
	/**
	**获取service_status数据列表
	*/
	public static List<Map<String,Object>> getServiceStatusList(){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		list.add(getMap("1","正常"));
		list.add(getMap("2","损坏"));
		return list;
	}
	public static String getServiceStatusNameById(String id){//根据service_status的key值获取名称
		List<Map<String,Object>> list = getServiceStatusList();
		return getNameById(id,list);
	}
	public static String getNameById(String id,List<Map<String,Object>> list){
		if(id==null){
			return null;
		}
		if(id.endsWith(",")){
			id = id.substring(0,id.length()-1);
		}
		String[] idsplit = id.split(",");
		String rs = "";
		for(String tmp:idsplit){
			for(Map<String,Object> map:list){
				if(map.get("id").toString().equals(tmp)){
					rs+=map.get("name").toString()+",";
				}
			}
		}
		if(rs.endsWith(",")){
			rs = rs.substring(0,rs.length()-1);
		}
		return rs;
	}
	private static Map<String,Object> getMap(String id,String name){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", id);
		map.put("name", name);
		return map;
	}
}
