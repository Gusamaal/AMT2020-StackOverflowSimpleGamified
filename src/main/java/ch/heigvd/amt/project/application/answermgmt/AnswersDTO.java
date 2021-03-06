package ch.heigvd.amt.project.application.answermgmt;

import ch.heigvd.amt.project.application.commentmgmt.CommentsDTO;
import ch.heigvd.amt.project.application.votemgmt.VotesDTO;
import ch.heigvd.amt.project.domain.user.UserId;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
@EqualsAndHashCode
public class AnswersDTO {

    @Builder
    @Getter
    @EqualsAndHashCode
    public static class AnswerDTO {
        private UUID id;
        private UUID questionID;
        private Date creationDate;
        private Date lastEditDate;
        private UserId ownerId;
        private String ownerName;
        private String body;
        private  int VoteTotal;

        private CommentsDTO comments;
        private VotesDTO votes;
    }

    @Singular
    private List<AnswerDTO> answers;
}
