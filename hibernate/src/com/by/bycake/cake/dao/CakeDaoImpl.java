package com.by.bycake.cake.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.by.bycake.entity.Cake;
import com.by.bycake.util.BaseDao;

/*
 * 实现对蛋糕表的增删改查
 */

@Repository
public class CakeDaoImpl extends BaseDao {
	
	//查找全部蛋糕
	public List<Cake> findAllCake(){
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Cake");
		return q.list();
	}
	
	/*
	 * 分页查询技术
	 * pageNum 当前页码
	 * pageSize 一页显示的条数
	 */
	public List<Cake> findByPage(int pageNum,int pageSize){
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Cake");
		q.setFirstResult((pageNum-1)*pageSize).setMaxResults(pageSize);
		return q.list();
	}
	
	//统计蛋糕个数
	public int findCakeCount() {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Cake");
		return q.list().size();
	}
	
	/*
	 * 根据typeid查询蛋糕数量
	 */
	public int findCakeCountByTypeid(int typeid) {
		System.out.println("[typeid为：]"+typeid);
		Session session = this.sessionFactory.getCurrentSession();
		//Query q = session.createQuery("from Cake c where c.comments is not null");
		Query q = session.createQuery("from Cake c where c.cakeType.typeid=?");
		q.setInteger(0, typeid);
		System.out.println("[cake-type-size:]"+q.list().size());
		return q.list().size();
	}
	
	/*
	 * 根据typeid查询蛋糕列表(选出对应页码的蛋糕条数)
	 */
	public List<Cake> findCakeByTypeid(int typeid,int pageNum,int pageSize){
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Cake c where c.cakeType.typeid=?");
		q.setInteger(0, typeid);
		q.setFirstResult((pageNum-1)*pageSize).setMaxResults(pageSize);
		return q.list();
	}
	
	/*
	 * 根据cakename查询蛋糕数量
	 */
	public int findCakeCountByCakename(String cakename) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Cake c where c.cakename=?");
		q.setString(0, cakename);
		return q.list().size();
	}
	
	/*
	 * 根据cakename查询蛋糕列表
	 */
	public List<Cake> findCakeByCakename(String cakename,int pageNum,int pageSize){
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Cake c where c.cakename=?");
		q.setString(0, cakename);
		q.setFirstResult((pageNum-1)*pageSize).setMaxResults(pageSize);
		return q.list();
	}
	
	//根据cakeid查找蛋糕
	public Cake findCakeByCakeid(int cakeid) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Cake c where c.cakeid=?");
		q.setInteger(0, cakeid);
		Cake cake = (Cake) q.uniqueResult();
		return cake;
	}
	//返回订单明细表销量前八名的蛋糕列表
	public List<Cake> findTopOrderCake(){
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("select c from Cake c,Ordermanage o where c.cakeid=o.cake.cakeid group by o.cake.cakeid order by sum(o.amount) desc)");
		q.setMaxResults(8);
		System.out.println("[销量前八：]:"+q.list());
		return q.list();
	}
}
