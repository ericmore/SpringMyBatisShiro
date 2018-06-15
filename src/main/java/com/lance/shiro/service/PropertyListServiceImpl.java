package com.lance.shiro.service;

import com.lance.shiro.entity.IPropertyList;
import com.lance.shiro.mapper.PropertyListMapper;
import com.lance.shiro.utils.ConvertUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.lance.shiro.config.ConstantVariable.*;

@Service
@Transactional
public class PropertyListServiceImpl implements PropertyListService {
    @Autowired
    private PropertyListMapper propertyListMapper;

    @Autowired
    private CommonService commonService;


    @Override
    public Map get(int id) {
        IPropertyList propertyList = propertyListMapper.get(id);
        Map mpropertyList = setAttachment(propertyList);
        return mpropertyList;
    }

    @Override
    public Map save(IPropertyList propertyList) throws IllegalAccessException {
        if (propertyList.getId() == 0) {
            propertyListMapper.add(propertyList);
        } else {
//            Field fields[] = propertyList.getClass().getDeclaredFields();
//            StringBuffer sb = new StringBuffer();
//            for (int i = 0; i < fields.length; i++) {
//                fields[i].setAccessible(true);
//                String keyName = fields[i].getName();
//                // 处理空值和double 默认0.0 不更新数据
//                if (fields[i].getAnnotation(Column.class) !=null && null != fields[i].get(propertyList) && !fields[i].get(propertyList).equals(0)) {
//                    String value = fields[i].get(propertyList).toString();
//                    sb.append("  ").append(keyName).append("=").append("'").append(value).append("'").append("  ").append(",");
//                }
//            }
//            if (null != sb) {
//                String s = sb.toString();
//                propertyListMapper.update(propertyList.getId(), s.substring(0, s.length() - 1));
//                propertyList = propertyListMapper.get(propertyList.getId());
//            }
            propertyListMapper.update(propertyList);
        }
        Map mpropertyList = setAttachment(propertyList);
        return mpropertyList;
    }

    /**
     * 删除
     *
     * @param ids
     */
    @Override
    public void deleteAllByIds(ArrayList<Integer> ids) {
        int size = ids.size();
        for (int i = 0; i < size; i++) {
            delete(ids.get(i));
        }
    }

    @Override
    public void delete(Integer id) {
        propertyListMapper.delete(id);
        String sid = String.valueOf(id);
        commonService.deleteListAttachmentByBelong(sid, BELONG_TO_CATEGORY_PROPERTY_LIST_LOGO);
        commonService.deleteListAttachmentByBelong(sid, BELONG_TO_CATEGORY_PROPERTY_LIST_MULTI_PICTURES);
        commonService.deleteListAttachmentByBelong(sid, BELONG_TO_CATEGORY_PROPERTY_LIST_BROCHURE);
    }

    @Override
    public ArrayList<Map> findAllByCitys(List<String> city) {
        ArrayList<IPropertyList> list;
        if (city != null && city.size() > 0) {
            String citys = "'" + StringUtils.join(city, "','") + "'";
            list = propertyListMapper.findAllByCitys(citys);
        } else {
            list = propertyListMapper.findAll();
        }
        ArrayList<Map> aPropertyLists = new ArrayList<Map>();
        for (int i = 0, size = list.size(); i < size; i++) {
            Map maPropertyList = setAttachment(list.get(i));
            aPropertyLists.add(maPropertyList);
        }
        return aPropertyLists;
    }

    /**
     * @param id
     * @param reqMap
     * @return
     */
    @Override
    public IPropertyList updateAttribute(int id, Map<String, String> reqMap) {
        IPropertyList iPropertyList = propertyListMapper.get(id);
        if (null != iPropertyList) {
            Field fields[] = iPropertyList.getClass().getDeclaredFields();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < fields.length; i++) {
                String keyName = fields[i].getName();
                if (null != reqMap.get(keyName)) {
                    sb.append("  ").append(keyName).append("=").append("'").append(reqMap.get(keyName)).append("'").append("  ").append(",");
                }
            }
            if (null != sb) {
                String s = sb.toString();
                propertyListMapper.updateAttribute(iPropertyList.getId(), s.substring(0, s.length() - 1));
                iPropertyList = propertyListMapper.get(id);
                return iPropertyList;
            }
        }
        return null;
    }

    /**
     * @param reqMap
     * @return
     */
    @Override
    public ArrayList<Map> findAllByAttr(Map<String, String> reqMap) {
        ArrayList<IPropertyList> list;
        if (null != reqMap && reqMap.size() > 0) {
            IPropertyList iPropertyList = new IPropertyList();
            Field fields[] = iPropertyList.getClass().getDeclaredFields();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < fields.length; i++) {
                String keyName = fields[i].getName();
                if (null != reqMap.get(keyName)) {
                    sb.append("  ").append(keyName).append("=").append("'").append(reqMap.get(keyName)).append("'").append("  ").append("and");
                }
            }
            if (null != sb) {
                String s = sb.toString();
                list = propertyListMapper.findAllByAttr(s.substring(0, s.length() - 3));
            } else {
                list = propertyListMapper.findAll();
            }
        } else {
            list = propertyListMapper.findAll();
        }
        ArrayList<Map> aPropertyLists = new ArrayList<>();
        if (null != list && list.size() > 0) {
            for (int i = 0, size = list.size(); i < size; i++) {
                Map maPropertyList = setAttachment(list.get(i));
                aPropertyLists.add(maPropertyList);
            }
        }
        return aPropertyLists;
    }


    private Map setAttachment(IPropertyList propertyList) {
        Map mpropertyList = ConvertUtils.beanToMap(propertyList);
        String id = String.valueOf(propertyList.getId());
        mpropertyList.put(BELONG_TO_CATEGORY_PROPERTY_LIST_LOGO, commonService.findListAttachmentByBelong(id, BELONG_TO_CATEGORY_PROPERTY_LIST_LOGO));
        mpropertyList.put(BELONG_TO_CATEGORY_PROPERTY_LIST_MULTI_PICTURES, commonService.findListAttachmentByBelong(id, BELONG_TO_CATEGORY_PROPERTY_LIST_MULTI_PICTURES));
        mpropertyList.put(BELONG_TO_CATEGORY_PROPERTY_LIST_BROCHURE, commonService.findListAttachmentByBelong(id, BELONG_TO_CATEGORY_PROPERTY_LIST_BROCHURE));
        return mpropertyList;
    }
}