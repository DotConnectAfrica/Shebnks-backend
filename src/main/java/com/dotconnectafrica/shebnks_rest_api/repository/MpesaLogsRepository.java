package com.dotconnectafrica.shebnks_rest_api.repository;

import com.dotconnectafrica.shebnks_rest_api.exception.GoodRequestException;
import com.dotconnectafrica.shebnks_rest_api.models.MpesaLogsModel;
import com.dotconnectafrica.shebnks_rest_api.payload.ApiResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

@Repository
public interface MpesaLogsRepository extends JpaRepository<MpesaLogsModel, Long> {

    //Boolean existsByOriginatorConversationID(@NotBlank String OriginatorConversationID);

    Optional<MpesaLogsModel> findTopByOriginatorConversationIDOrderByIdDesc(@NotBlank String OriginatorConversationID);

    default MpesaLogsModel getOriginatorConversationID(String OriginatorConversationID) {
        return findTopByOriginatorConversationIDOrderByIdDesc(OriginatorConversationID)
                .orElseThrow(() -> new GoodRequestException(new ApiResponse(Boolean.TRUE, "Oops! An error occurred"))) ;
    }
}
