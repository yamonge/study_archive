import {
  Container as MapDiv,
  NaverMap,
  Marker,
  NavermapsProvider,
} from "react-naver-maps";

function MyMap({ lat, lng }) {
  return (
    <NavermapsProvider
      ncpKeyId="28n51run07" // 여기에 발급받은 API 키 입력
    >
      <MapDiv
        style={{
          border: "1px solid black",  
          width: "100%",
          height: "300px", // 블로그처럼 적당한 높이
        }}
      >
        <NaverMap
          defaultCenter={{ lat: lat, lng: lng }} // 전달받은 위도, 경도
          defaultZoom={16} // 블로그 지도는 보통 15~16 정도의 줌 레벨
        >
          {/* 마커 하나 딱 찍어주기 */}
          <Marker position={{ lat: lat, lng: lng }} />
        </NaverMap>
      </MapDiv>
    </NavermapsProvider>
  );
}

export default MyMap;
