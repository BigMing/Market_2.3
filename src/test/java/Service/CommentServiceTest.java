package Service;

import Dao.model.Comment;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml","file:src/main/webapp/WEB-INF/spring-mybatis.xml"})


public class CommentServiceTest extends TestCase {

    @Autowired
    CommentService commentService;

    @Test
    public void testSaveComments() throws Exception {
        //System.out.print(commentService.saveComments("被举报",0,1));
    }

    @Test
    public void testShowComments() throws Exception {
        Comment[]comments = commentService.showComments(5);
        System.out.println(comments[0].getCommenttext());
    }

    @Test
    public void testDelete() throws Exception{
        //System.out.print(commentService.deleteComment(3,2));
    }
}