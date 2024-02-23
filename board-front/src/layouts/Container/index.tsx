import { Outlet, useLocation } from 'react-router-dom'
import Footer from 'layouts/Footer'
import Header from 'layouts/Header'
import { AUTH_PATH } from 'constant';

//          component : 레이아웃          //
export default function Container() {

  //          state : 현재 페이지 path name 상태          //
  const { pathname } = useLocation();

  //          render : 렌더링          //
  return (
    <>
      <Header />
      {/* Outlet : 중첩된 라우트의 하위 라우트 렌더링 해줌 */}
      <Outlet />
      {pathname !== AUTH_PATH() && <Footer />}
    </>
  )
}
