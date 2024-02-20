import React from 'react';
// import logo from './logo.svg';
import './App.css';
//import BoardItem from 'components/BoardItem';
//import { latestBoardListMock } from 'mocks';
import Top3Item from 'components/Top3Item';
import { top3BoardListItem } from 'mocks';
import BoardItem from 'components/BoardItem';

function App() {
  return (
    <>
      {/* {latestBoardListMock.map(boardListItem => <BoardItem boardListItem={boardListItem}/>)} */}
      <div style={{display: 'flex', justifyContent: 'center', gap:'24px'}}>
        {top3BoardListItem.map(top3ListItem => <Top3Item top3ListItem={top3ListItem} />)}
      </div>
    </>
  );
}

export default App;
