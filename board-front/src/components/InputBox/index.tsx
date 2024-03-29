import {KeyboardEvent, ChangeEvent, forwardRef } from 'react';
import './style.css';

//          interface : Input Box 컴포넌트 Properties          //
interface Props{
    label: string;
    // ts 리터럴 타입 사용
    type: 'text' | 'password'; 
    placeholder: string;
    value: string;
    onChange: (event: ChangeEvent<HTMLInputElement>) => void;
    error: boolean;

    // ? : 옵셔널, 필수 X
    icon?: 'eye-light-off-icon' | 'eye-light-on-icon' | 'expand-right-light-icon';
    onButtonClick?: () => void;
    
    message?: string;

    // KeyboardEvent import 안되면 직접 넣어주기
    onKeyDown?: (event: KeyboardEvent<HTMLInputElement>)=> void;
}

//          component : Input Box 컴포넌트          //
const InputBox = forwardRef<HTMLInputElement, Props>((props: Props, ref) => {

    //          state : properties          //
    const {label, type, error, placeholder, value, icon, message} = props;
    const {onChange, onButtonClick, onKeyDown} = props;

    //          event handler : Input Box 키 다운 이벤트 처리          //
    const onKeydownHandler = (event: KeyboardEvent<HTMLInputElement>) => {
        if(!onKeyDown) return;
        onKeyDown(event);
    }

    //          render : Input Box 렌더링          //
    return (
        <div className='inputbox'>
            <div className='inputbox-label'>{label}</div>
            <div className={error ? 'inputbox-container-error' : 'inputbox-container'}>
                {/* ref : 키보드 엔터치면 넘어가게 하는 역할 */}
                <input ref={ref} type={type} className='input' placeholder={placeholder} value={value} onChange={onChange} onKeyDown={onKeydownHandler}/>
                {/* onButtonClick이 undefined이 아니면 컴포넌트 랜더링 됨 */}
                {onButtonClick !== undefined && (
                    <div className='icon-button' onClick={onButtonClick}>
                                                            {/* 템플릿 리터럴 사용 */}
                        {icon !== undefined && (<div className={`icon ${icon}`}></div>)}
                    </div>
                )}
            </div>
            {message !== undefined &&(
                <div className='inputbox-message'>{message}</div>
            )}
        </div>

    )

});

export default InputBox;