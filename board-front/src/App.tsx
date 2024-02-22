import React, { useState } from 'react';
// import logo from './logo.svg';
import './App.css';
//import BoardItem from 'components/BoardItem';
//import { latestBoardListMock } from 'mocks';
import Top3Item from 'components/Top3Item';
import { commentListMock, favoriteListMock, top3BoardListItem } from 'mocks';
import BoardItem from 'components/BoardItem';
import CommentItem from 'components/CommentItem';
import FavoriteItem from 'components/FavoriteItem';
import InputBox from 'components/InputBox';

function App() {

  const [value, setValue] = useState<string>('');

  return (
    <>
      {/* {latestBoardListMock.map(boardListItem => <BoardItem boardListItem={boardListItem}/>)} */}
      {/* <div style={{display: 'flex', justifyContent: 'center', gap:'24px'}}>
        {top3BoardListItem.map(top3ListItem => <Top3Item top3ListItem={top3ListItem} />)}
      </div> */}
      {/* <div style={{padding: '0 20px', display: 'flex', flexDirection: 'column', gap: '30px'}}>
        {commentListMock.map(commentListItem => <CommentItem commentListItem={commentListItem}/>)}
      </div> */}
      {/* <div style={{padding: '0 20px', display: 'flex', columnGap: '30px'}}>
        {favoriteListMock.map(favoriteListItem => <FavoriteItem favoriteListItem={favoriteListItem} />)}
      </div> */}
      <InputBox label={'이메일'} type={'text'} placeholder={'이메일 주소를 입력해주세요.'} value={value} setValue={setValue } error={true} />
    </>
  );
}

export default App;
