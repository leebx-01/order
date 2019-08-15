package com.leebx.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.leebx.entity.BaseDict;
import com.leebx.entity.SysUser;

public class UserDaoImpl extends BaseDaoImpl<SysUser> implements UserDao {

	public UserDaoImpl() {
		super(SysUser.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public SysUser login(final SysUser s) {
		// TODO Auto-generated method stub
		return super.getHibernateTemplate().execute(new HibernateCallback<SysUser>() {

			@Override
			public SysUser doInHibernate(Session session)
					throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				Query query = session.createQuery("from SysUser s where s.userCode=:userCode and s.userPassword=:userPassword");
				query.setProperties(s);
				return (SysUser)query.uniqueResult();
			}
		});
	}

	@Override
	public void regist(SysUser s) {
		// TODO Auto-generated method stub
		super.getHibernateTemplate().save(s);
	}

}
