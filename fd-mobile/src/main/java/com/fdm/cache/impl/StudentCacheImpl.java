package com.fdm.cache.impl;

import org.springframework.stereotype.Component;

import com.fdm.cache.BaseCacheImpl;
import com.fdm.cache.dao.StudentCache;

@Component
public class StudentCacheImpl extends BaseCacheImpl implements StudentCache {

	final String KEY_AREA_PCD = NAME_SPACE + "area:pcd";

	final String KEY_AREA_ID_SUBAREA = NAME_SPACE + "area:id:subArea:";

	final String KEY_AREA_ID = NAME_SPACE + "area:id:";


}
