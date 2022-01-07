package models;

import lombok.*;

@Builder
public @Data
class CreateVote {

    @Builder.Default
    private String sub_id = "my-user-1234";

    @Builder.Default
    private String image_id = "l1qe";

    @Builder.Default
    private int value = 0;
}