package hellojpa;

import jakarta.persistence.*;
import org.hibernate.Transaction;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        //트랜잭션 만들기: 작업 상태관리 느낌인거 같음
        EntityTransaction tx = em.getTransaction();

        //트랜잭션 시작
        tx.begin();

        try{
            //Member member = em.find(Member.class, 1L);
            //member.setName("HelloJpa");

//            List<Member> resultList = em.createQuery("SELECT M FROM Member AS M WHERE M.id>0L", Member.class).getResultList();
//
//
//            for(Member member : resultList) {
//                System.out.println(member.getName());
//            }

//            Member member = new Member(150L,"A");
//            em.persist(member);
//            Member member = em.find(Member.class, 150L);
//            System.out.println(member);

//            Member member = em.find(Member.class, 150L);
//            em.remove(member);
//            //작업 알림
//            tx.commit();

             Member member = new Member(150L,"A");
             em.persist(member);
             em.flush();
            System.out.println("=============");
            tx.commit();

        }
        catch (Exception e){
            //작업 되돌리기
            tx.rollback();
        }
        finally {
            em.close();
        }

        emf.close();
    }
}
