<h2>날씨 다이어리 프로젝트</h2>
<p>
  Open Weather Map api를 통해 날씨 데이터를 얻어와 그날의 날씨와 나의 일기를 같이 저장해서 기록하는 다이어리
</p>
<br>
<p>
  <h3>개발 환경</h3>
  <ul>
      <li>Intellij Community</li>
      <li>Spring Boot version 3.2.2</li>
      <li>Project Gradle - Groovy</li>
      <li>Language - Java</li>
  </ul>
</p>
<br>
<p>
  <h3>구현되어 있는 API</h3>
  <ul>
      <li>POST - 다이어리를 생성하는 api
        <p>
          date와 text를 parameter로 받아 외부 API에서 받아온 날씨 데이와 함께 DB에 저장한다. 
        </p>
      </li>
      <li>GET - 조회된 날짜, 기간에 해당에 해당하는 다이어리를 보여주는 api</li>
      <li>PUT - 입력 날짜의 다이어리를 수정하는 api</li>
      <li>DELETE - 입력 날짜의 다이어리를 삭제하는 api</li>
  </ul>
</p>
