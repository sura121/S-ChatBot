package com.sura.resource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Cities {

    SEOUL("서울특별시"),
    BUSAN("부산광역시"),
    INCHEON("인천광역시"),
    DAEGU("대구광역시"),
    DAEJUN("대전광역시"),
    GWANGJU("광주광역시"),
    SUWAN("경기도 수원시"),
    UALSAN("울산광역시"),
    GOYANG("경기도 고양시"),
    YONGIN("경기도 용인시"),
    CHANGWON("경상남도 창원시"),
    SEONGNAM("경기도 성남시"),
    CHUNGJOO("충청북도 청주시"),
    BUCHEON("경기도 부천시"),
    HAWSEONG("경기도 화성시"),
    NAMYANG("경기도 남양주시"),
    JEONJU("전라북도 전주시"),
    CHEONAN("충청남도 천안시"),
    ANSAN("경기도 안산시"),
    ANYANG("경기도 안양시"),
    KIMHAE("경상남도 김해시"),
    PYENGTAEK("경기도 평택시"),
    POHAWNG("경상북도 포항시"),
    JAEJU("제주특별자치도 제주시"),
    SIHNG("경기도 시흥시"),
    PAJOO("경기도 파주시"),
    UIJEONGBU("경기도 의정부시"),
    KIMPO("경기도 김포시"),
    GOOMI("경상북도 구미시"),
    GAWNJOO("경기도 광주시"),
    YANGSAN("경상남도 양산시"),
    WONJOO("강원도 원주시"),
    JINJOO("경상남도 진주시"),
    SEJONG("세종특별자치시"),
    GAWNGMYUNG("경기도 광명시"),
    ASAN("충청남도 아산시"),
    IKSAN("전라북도 익산시"),
    CHOONCHEON("강원도 춘천시"),
    GYUNGSAN("경상북도 경산시"),
    GONPO("경기도 군포시"),
    GUNSAN("전라북도 군산시"),
    HANAM("경기도 하남시"),
    YEOSOO("전라남도 여수시"),
    SOONCHEON("전라남도 순천시"),
    GYUNGJOO("경상북도 경주시"),
    GUJE("경상남도 거제시"),
    MOKPO("전라남도 목포시"),
    OSAN("경기도 오산시"),
    ECHUN("경기도 이천시"),
    GANGRNG("강원도 강릉시"),
    YANGJOO("경기도 양주시"),
    CHOONGJU("충청북도 충주시"),
    ANSEONG("경기도 안성시"),
    GURI("경기도 구리시"),
    SEOSAN("충청남도 서산시"),
    SEOGIPO("제주특별자치도 서귀포시"),
    DANGJIN("충청남도 당진시"),
    ANDON("경상북도 안동시"),
    POCHEON("경기도 포천시"),
    UIWANG("경기도 의왕시"),
    GAWNGYANG("전라남도 광양시"),
    KIMCHEON("경상북도 김천시"),
    JECHEON("충청북도 제천시"),
    TONGYUNG("경상남도 통영시"),
    NONSAN("충청남도 논산시"),
    CHILGOCK("경상북도 칠곡군"),
    SACEHON("경상남도 사천시"),
    YEOJOO("경기도 여주시"),
    GOONGJO("충청남도 공주시"),
    YANGPYEONG("경기도 양평군"),
    JUNGEUP("전라북도 정읍시"),
    YANGJU("경상북도 영주시"),
    NAJU("전라남도 나주시"),
    EUMSEONG("충청북도 음성군"),
    MILYANG("경상남도 밀양시"),
    HNGSEONG("충청남도 홍성군"),
    BORYENG("충청남도 보령시"),
    WANJU("전라북도 완주군"),
    SANGJU("경상북도 상주시"),
    YEUNGCHEON("경상북도 영천시"),
    DONGDUCHU("경기도 동두천시"),
    DONGHAE("강원도 동해시"),
    KIMJAE("전라북도 김제시"),
    MOOIN("전라남도 무안군"),
    NAMWON("전라북도 남원시"),
    JINCHEON("충청북도 진천군"),
    YESAN("충청남도 예산군"),
    SOKCHO("강원도 속초시"),
    MONGEUNG("경상북도 문경시"),
    HAMAN("경상남도 함안군"),
    SAMCHUCK("강원도 삼척시"),
    HONGCHUN("강원도 홍천군"),
    HAENAM("전라남도 해남군"),
    BOOYEU("충청남도 부여군"),
    CHANGNYEUNG("경상남도 창녕군"),
    TAEAN("충청남도 태안군"),
    GOHNG("전라남도 고흥군"),
    HAWSOON("전라남도 화순군"),
    CUCHANG("경상남도 거창군"),
    GAPYENG("경기도 가평군"),
    YENGAM("전라남도 영암군"),
    GMSAN("충청남도 금산군"),
    GOCHANG("전라북도 고창군"),
    GAWCHEON("경기도 과천시"),
    SEOCHEON("충청남도 서천군"),
    GOSUNG("경상남도 고성군"),
    BUAN("전라북도 부안군"),
    UISEONG("경상북도 의성군"),
    OKCHEON("충청북도 옥천군"),
    YUNGGAWNG("전라남도 영광군"),
    YUNGDONG("충청북도 영동군"),
    ULJIN("경상북도 울진군"),
    WANDO("전라남도 완도군"),
    YECHEON("경상북도 예천군"),
    CHULWON("강원도 철원군"),
    TAEBAEK("강원도 태백시"),
    YEONCHUN("경기도 연천군"),
    DAMYANG("전라남도 담양군"),
    HAMCHEON("경상남도 합천군"),
    HADONG("경상남도 하동군"),
    HOENGSEONGH("강원도 횡성군"),
    NAMHAE("경상남도 남해군"),
    GAERYONG("충청남도 계룡시"),
    JANGSEONG("전라남도 장성군"),
    CHEONGDO("경상북도 청도군"),
    SUNGJU("경상북도 성주군"),
    PYENGCHANG("강원도 평창군"),
    BOSEONG("전라남도 보성군"),
    GAISAN("충청북도 괴산군"),
    HAMYANG("경상남도 함양군"),
    JNGPYENG("충청북도 증평군"),
    YEONGWAL("강원도 영월군"),
    JANGHNG("전라남도 장흥군"),
    YEONGDUCK("경상북도 영덕군"),
    JEONGSUN("강원도 정선군"),
    SINAN("전라남도 신안군"),
    SANCHEON("경상남도 산청군"),
    GANGJIN("전라남도 강진군"),
    GORYENG("경상북도 고령군"),
    BOEN("충청북도 보은군"),
    CHEONGYANG("충청남도 청양군"),
    BONGHAW("경상북도 봉화군"),
    HAMPYENG("전라남도 함평군"),
    INJAE("강원도 인제군"),
    JINDO("전라남도 진도군"),
    GOKSEONG("전라남도 곡성군"),
    GOSEONG("강원도 고성군"),
    DANYANG("충청북도 단양군"),
    SOONCHANG("전라북도 순창군"),
    IMSIL("전라북도 임실군"),
    UIREYUNG("경상남도 의령군"),
    YANGYANG("강원도 양양군"),
    HAWCHEON("강원도 화천군"),
    CHEONGSONG("경상북도 청송군"),
    GURYE("전라남도 구례군"),
    MOOJU("전라북도 무주군"),
    JINAN("전라북도 진안군"),
    YANGGU("강원도 양구군"),
    GOONWI("경상북도 군위군"),
    JANGSU("전라북도 장수군"),
    YUNGYANG("경상북도 영양군"),
    ULRNG("경상북도 울릉군");

    private String city;

    Cities(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public static Cities findByCity(String city) {
       return Arrays.stream(Cities.values())
                .filter(Cities -> Cities.getCity().contains(city))
                .findAny()
                .orElse(null);
    }


}
