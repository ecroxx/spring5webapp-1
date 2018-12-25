/*package guru.springframework.spring5webapp.DAO;

import guru.springframework.spring5webapp.model.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import java.util.List;
import java.util.Set;


@Repository
@Transactional
public class CarDAO {

    @Autowired
    SessionFactory sessionFactory;

    public void save(Car car) {
        Session session= sessionFactory.getCurrentSession();
        session.saveOrUpdate(car);
    }

    public List<Car> getCars(){
 String hql="SELECT * FROM CAR WHERE CAR.YEAR="
        Session session=sessionFactory.getCurrentSession();
        CriteriaBuilder builder =session.getCriteriaBuilder();
       CriteriaQuery<Car>criteriaQuery=builder.createQuery(Car.class);
       criteriaQuery.from(Car.class);
        Query query =criteriaQuery;
        query.se

       List<Car> list = session.createQuery(criteriaQuery).getResultList();
       return list;


    }

    public void delete(Car car){


    }

}
*/