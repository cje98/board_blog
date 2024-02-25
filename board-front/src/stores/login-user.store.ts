// 콘솔에서 npm i zustand 먼저 설치하기

import { User } from "types/interface";
import { create } from "zustand";

interface LoginUserStore {
    loginUser: User | null;

    // User 타입인 loginUser를 받아오겠다.
    setLoginUser: (loginUser: User) => void;
    resetLoginUser: () => void;
};

// import zustand인지 확인하기!
const useLoginUserStore = create<LoginUserStore>(set => ({
    loginUser: null,
    setLoginUser: (loginUser) => set(state => ({...state, loginUser})),
    resetLoginUser: () => set(state => ({ ...state, loginUser: null }))
}));

export default useLoginUserStore;