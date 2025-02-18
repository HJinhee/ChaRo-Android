package com.example.charo_android.presentation.util

class LocationUtil {
    val location = hashMapOf(
        "고성" to "goseong",
        "강릉" to "gangneung",
        "동해" to "donghae",
        "삼척" to "samcheok",
        "속초" to "sokcho",
        "양구" to "yanggu",
        "양양" to "yangyang",
        "영월" to "yeongwol",
        "인제" to "inje",
        "정선" to "jeongseon",
        "철원" to "cheorwon",
        "춘천" to "chuncheon",
        "태백" to "taebaek",
        "평창" to "pyeongchang",
        "홍천" to "hongcheon",
        "화천" to "hwacheon",
        "횡성" to "hoengseong",

        "계룡" to "gyeryong",
        "공주" to "gongju",
        "금산" to "geumsan",
        "논산" to "nonsan",
        "당진" to "dangjin",
        "보령" to "boryeong",
        "부여" to "buyeo",
        "서산" to "seosan",
        "서천" to "seocheon",
        "아산" to "asan",
        "예산" to "yesan",
        "천안" to "cheonan",
        "청양" to "cheongyang",
        "태안" to "taean",
        "홍성" to "hongseong",

        "괴산" to "goisan",
        "단양" to "danyang",
        "보은" to "boeun",
        "영동" to "yeongdong",
        "옥천" to "okcheon",
        "음성" to "eumseong",
        "제천" to "jecheon",
        "증평" to "jeungpyeong",
        "진천" to "jincheon",
        "청주" to "cheongju",
        "충주" to "chungju",
        "경산" to "gyeongsan",
        "경주" to "gyengju",
        "고령" to "goryeong",
        "구미" to "gumi",
        "군위" to "gunui",
        "김천" to "gimcheon",
        "독도" to "dokdo",
        "문경" to "mungyeong",
        "봉화" to "bongwha",
        "상주" to "sangju",
        "성주" to "seongju",
        "안동" to "andong",
        "영덕" to "yeongdeok",
        "영양" to "yeongyang",
        "영주" to "yeongju",
        "영천" to "yeongcheon",
        "예천" to "yecheon",
        "울릉" to "ulleung",
        "울진" to "uljin",
        "의성" to "uiseong",
        "청도" to "cheongdo",
        "청송" to "cheongsong",
        "칠곡" to "chilgok",
        "포항" to "pohang",

        "서울" to "seoul",
        "제주" to "jeju",
        "부산" to "busan",
        "대구" to "dague",
        "인천" to "incheon",
        "울산" to "ulsan",
        "대전" to "daejeon",
        "광주" to "gwangju",
        "가평" to "gapyeong",
        "고양" to "goyang",
        "과천" to "gwacheon",
        "광주" to "kwangju",
        "구리" to "guri",
        "군포" to "gunpo",
        "김포" to "gimpo",
        "남양주" to "namyangju",
        "동두천" to "dongducheon",
        "부천" to "bucheon",
        "성남" to "seongnam",
        "수원" to "suwon",
        "시흥" to "siheung",
        "안산" to "ansan",
        "안성" to "anseong",
        "안양" to "anyang",
        "양주" to "yangju",
        "양평" to "yangpeong",
        "여주" to "yeoju",
        "연천" to "yeonchen",
        "오산" to "osan",
        "용인" to "yongin",
        "의왕" to "uewang",
        "의정부" to "uejeongbu",
        "이천" to "icheon",
        "파주" to "paju",
        "평택" to "peongtak",
        "포천" to "pocheon",
        "하남" to "hanam",
        "화성" to "hwaseong",

        "거제" to "geoje",
        "거창" to "geochang",
        "고성" to "goseong",
        "김해" to "gimhae",
        "남해" to "namhae",
        "밀양" to "miryang",
        "사천" to "sichuan",
        "산청" to "sancheong",
        "양산" to "yangsan",
        "의령" to "uiryeong",
        "진주" to "jinju",
        "창녕" to "changnyeong",
        "창원" to "changwon",
        "통영" to "tongyeong",
        "하동" to "hadong",
        "함안" to "haman",
        "함양" to "hamyang",
        "합천" to "hapcheon",

        "고창" to "gochang",
        "군산" to "gunsan",
        "김제" to "gimje",
        "남원" to "namwon",
        "무주" to "muju",
        "부안" to "buan",
        "순창" to "sunchang",
        "완주" to "wanju",
        "익산" to "iksan",
        "임실" to "imsil",
        "장수" to "jangsu",
        "전주" to "jeonju",
        "정읍" to "jeongeup",
        "진안" to "jinan",

        "강진" to "kangjin",
        "고흥" to "goheung",
        "곡성" to "gokseong",
        "광양" to "gwangyang",
        "구례" to "gurye",
        "나주" to "naju",
        "담양" to "damyang",
        "목포" to "mokpo",
        "무안" to "muan",
        "보성" to "boseong",
        "순천" to "suncheon",
        "신안" to "sinan",
        "여수" to "yeosu",
        "영광" to "younggwang",
        "영암" to "yeongam",
        "완도" to "wando",
        "장성" to "jangsung",
        "장흥" to "jangheung",
        "진도" to "jindo",
        "함평" to "hampyeong",
        "해남" to "haenam",
        "화순" to "hwasun"
    )

    val itemSpecial = arrayOf("선택안함", "서울", "제주")

    val itemProvince =
        arrayOf("선택안함", "특별시", "광역시", "경기도", "강원도", "충청남도", "충청북도", "경상북도", "경상남도", "전라북도", "전라남도")
    val itemMetroPolitan = arrayOf("선택안함", "부산", "대구", "인천", "울산", "대전", "광주")

    val itemGyounGi = arrayOf(
        "선택안함",
        "가평",
        "고양",
        "과천",
        "광명",
        "광주",
        "구리",
        "군포",
        "김포",
        "남양주",
        "동두천",
        "부천",
        "성남",
        "수원",
        "시흥",
        "안산",
        "안성",
        "안양",
        "양주",
        "양평",
        "여주",
        "연천",
        "오산",
        "용인",
        "의왕",
        "의정부",
        "이천",
        "파주",
        "평택",
        "포천",
        "하남",
        "화성"
    )

    val itemGangWon = arrayOf(
        "선택안함",
        "고성",
        "강릉",
        "동해",
        "삼척",
        "속초",
        "양구",
        "양양",
        "영월",
        "인제",
        "원주",
        "정선",
        "철원",
        "춘천",
        "태백",
        "평창",
        "홍천",
        "화천",
        "횡성"
    )

    val itemChoongChungNam = arrayOf(
        "선택안함",
        "계룡",
        "공주",
        "금산",
        "논산",
        "당진",
        "보령",
        "부여",
        "서산",
        "서천",
        "아산",
        "예산",
        "천안",
        "청양",
        "태안",
        "홍성"
    )

    val itemChoongChungBuk =
        arrayOf("선택안함", "괴산", "단양", "보은", "영동", "옥천", "음성", "제천", "증평", "진천", "청주", "충주")

    val itemGyungSangBuk = arrayOf(
        "선택안함",
        "경산",
        "경주",
        "고령",
        "구미",
        "군위",
        "김천",
        "독도",
        "문경",
        "봉화",
        "상주",
        "성주",
        "안동",
        "영덕",
        "영양",
        "영주",
        "영천",
        "예천",
        "울릉",
        "울진",
        "의성",
        "청도",
        "청송",
        "칠곡",
        "포항"
    )
    val itemGyungSanNam = arrayOf(
        "선택안함",
        "거제",
        "거창",
        "고성",
        "김해",
        "남해",
        "밀양",
        "사천",
        "산청",
        "양산",
        "의령",
        "진주",
        "창녕",
        "창원",
        "통영",
        "하동",
        "함안",
        "함양",
        "합천"
    )

    val itemJungLaBuk = arrayOf(
        "선택안함",
        "고창",
        "군산",
        "김제",
        "남원",
        "무주",
        "부안",
        "순창",
        "완주",
        "익산",
        "임실",
        "장수",
        "전주",
        "정읍",
        "진안"
    )

    val itemJungLaNam = arrayOf(
        "선택안함",
        "강진",
        "고흥",
        "곡성",
        "광양",
        "구례",
        "나주",
        "담양",
        "목포",
        "무안",
        "보성",
        "순천",
        "신안",
        "여수",
        "영광",
        "영암",
        "완도",
        "장성",
        "장흥",
        "진도",
        "함평",
        "해남",
        "화순"
    )
}
