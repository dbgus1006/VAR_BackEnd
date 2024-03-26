package shootingstar.var.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import shootingstar.var.dto.req.UserApplyVipDto;
import shootingstar.var.dto.res.UserAuctionSuccessList;
import shootingstar.var.entity.VipApprovalType;
import shootingstar.var.entity.VipInfo;
import shootingstar.var.repository.AuctionRepository;
import shootingstar.var.repository.Vip.VipInfoRepository;

@Service
@RequiredArgsConstructor
public class BasicService {
    private final VipInfoRepository vipInfoRepository;
    private final AuctionRepository auctionRepository;
    public void applyVip(String userUUID , UserApplyVipDto userApplyVipDto){
        VipInfo vipInfo = VipInfo.builder()
                .vipInfoUUID(userUUID)
                .vipName(userApplyVipDto.getVipName())
                .vipJob(userApplyVipDto.getVipJob())
                .vipCareer(userApplyVipDto.getVipCareer())
                .vipIntroduce(userApplyVipDto.getVipIntroduce())
                .vipApprovalType(VipApprovalType.STANDBY)
                .vipEvidenceUrl(userApplyVipDto.getVipEvidenceUrl())
                .build();

        vipInfoRepository.save(vipInfo);
    }
    public Page<UserAuctionSuccessList> successAuctionList(String userUUID, Pageable pageable){
        return null;
        //return auctionRepository.findAllSuccessByuserUUID(userUUID,pageable);
    }
}
