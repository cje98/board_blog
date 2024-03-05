import { User } from 'types/interface';
import ResponseDto from '../response.dto';

// User 인터페이스 상속받음(동일한 필드)
export default interface GetSignInUserResponseDto extends ResponseDto, User{
        
}