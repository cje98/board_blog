import Footer from 'layouts/Footer';
import './App.css';
import { Route, Routes } from 'react-router-dom';
import Main from 'views/Main';
import Authentication from 'views/Authentication';
import User from 'views/User';
import Search from 'views/Search';
import BoardDetail from 'views/Board/Detail';
import BoardWrite from 'views/Board/Write';
import BoardUpdate from 'views/Board/Update';
import Container from 'layouts/Container';
import { MAIN_PATH } from 'constant';
import { AUTH_PATH } from 'constant';
import { SEARCH_PATH } from 'constant';
import { USER_PATH } from 'constant';
import { BOARD_PATH } from 'constant';
import { BOARD_WRITE_PATH } from 'constant';
import { BOARD_DETAIL_PATH } from 'constant';
import { BOARD_UPDATE_PATH } from 'constant';

//          component : Application 컴포넌트          //
function App() {
  
  //          render : Application 렌더링          //
  // description : 메인 화면 > '/' - Main(컴포넌트명) //
  // description : 로그인 + 회원가입 > '/auth' - Authentication //
  // description : 검색 화면 > '/search/:searchWord' - Search //
  // description : 유저 페이지 > '/user/:userEmail' - User //
  // board는 하나로 묶어서 처리
  // description : 게시물 상세보기 > '/board/detail/:boardNumber' - BoardDetail //
  // description : 게시물 작성하기 > '/board/write' - BoardWrite //
  // description : 게시물 수정하기 > '/board/update/:boardNumber' - BoardUpdate //

  return (
    <Routes>
      <Route element={<Container />}>
        <Route path={MAIN_PATH()} element={<Main />}/>
        <Route path={AUTH_PATH()} element={<Authentication />}/>
        <Route path={SEARCH_PATH(':searchWord')} element={<Search />}/>
        <Route path={USER_PATH(':userEmail')} element={<User />}/>
        {/* 
          board가 공통되어 상/하위 라우트로 정의
          상위 라우트는 element 작성 안함(하위 라우트로 렌더링 하기 위함)
        */}
        {/* 하위 라우트 path='write'로 '/' 없이 작성(상대 경로) */}
        <Route path={BOARD_PATH()}>
          <Route path={BOARD_WRITE_PATH()} element={<BoardWrite />}/>
          <Route path={BOARD_UPDATE_PATH(':boardNumber')} element={<BoardUpdate />}/>
          <Route path={BOARD_DETAIL_PATH(':boardNumber')} element={<BoardDetail />}/>
        </Route>
        <Route path='*' element={<h1>404 Not Found</h1>} />
      </Route>
    </Routes>
  );
}

export default App;
