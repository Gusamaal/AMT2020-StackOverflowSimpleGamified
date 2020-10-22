package ch.heigvd.amt.project.infrastructure.persistence.jdbc.pgsql;

import ch.heigvd.amt.project.domain.answer.Answer;
import ch.heigvd.amt.project.domain.answer.AnswerId;
import ch.heigvd.amt.project.domain.answer.IAnswerRepository;
import ch.heigvd.amt.project.domain.comment.Comment;
import ch.heigvd.amt.project.domain.comment.CommentId;
import ch.heigvd.amt.project.domain.comment.ICommentRepository;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.sql.DataSource;
import java.util.Collection;
import java.util.Optional;

@ApplicationScoped
@Named("PgsqlUserRepository")
public class PgsqlCommentRepository extends PgsqlRepository<Comment, CommentId> implements ICommentRepository {

    @Resource(lookup = "jdbc/stackoverflowsimple")
    private DataSource dataSource;

    public static final String TABLE_ATTRIBUT_CLE = "pk_comment";
    public static final String TABLE_ATTRIBUT_OWNER = "fk_ownerId";
    public static final String TABLE_ATTRIBUT_QUESTION = "fk_questionId";
    public static final String TABLE_ATTRIBUT_ANSWER = "fk_answerId";
    public static final String TABLE_ATTRIBUT_CREATION_DATE = "creationDate";
    public static final String TABLE_ATTRIBUT_LAST_EDIT_DATE = "lastEditDate";
    public static final String TABLE_ATTRIBUT_BODY = "body";




    public static final String SQL_INSERT = "INSERT INTO postgres.stackoverflowsimple.comments "
            + "("+TABLE_ATTRIBUT_CLE+","
            + TABLE_ATTRIBUT_OWNER+", "
            + TABLE_ATTRIBUT_QUESTION + ", "
            + TABLE_ATTRIBUT_ANSWER + ", "
            + TABLE_ATTRIBUT_CREATION_DATE+", "
            + TABLE_ATTRIBUT_LAST_EDIT_DATE+", "
            + TABLE_ATTRIBUT_BODY+")"
            + " VALUES (?, ?, ?, ?, ?, ?, ?)";

   public static final String SQL_UPDATE_BY_ID = "UPDATE postgres.stackoverflowsimple.comments "
            + "SET "+TABLE_ATTRIBUT_LAST_EDIT_DATE+" = ?,"
            + TABLE_ATTRIBUT_BODY+" = ? "
            + "WHERE " + TABLE_ATTRIBUT_CLE +" = ? ";

   public static final String SQL_DELETE_BY_ID = "DELETE FROM postgres.stackoverflowsimple.comments "
            + "WHERE "+TABLE_ATTRIBUT_CLE+" = ?";

   public static final String SQL_SELECT_ALL = "SELECT "
           +TABLE_ATTRIBUT_CLE+","
           + TABLE_ATTRIBUT_OWNER+", "
           + TABLE_ATTRIBUT_QUESTION + ", "
           + TABLE_ATTRIBUT_ANSWER + ", "
           + TABLE_ATTRIBUT_CREATION_DATE+", "
           + TABLE_ATTRIBUT_LAST_EDIT_DATE+", "
           + TABLE_ATTRIBUT_BODY+ " "
            + "FROM postgres.stackoverflowsimple.comments  ";

   public static final String SQL_SELECT_BY_ID = SQL_SELECT_ALL
            + " WHERE "+TABLE_ATTRIBUT_CLE+" = ? ";


    @Override
    public void save(Comment entity) {

    }

    @Override
    public void remove(CommentId id) {

    }

    @Override
    public Optional<Comment> findById(CommentId id) {
        return Optional.empty();
    }

    @Override
    public Collection<Comment> findAll() {
        return null;
    }
}
