import { ResponseCode } from "types/enum";
// from 상대경로 > 절대경로로 바꾸는 법 : tsconfig.json에서 "baseUrl": "./src" 추가
export default interface ResponseDto{
    code: ResponseCode;
    message: string;
}