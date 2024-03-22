export const convertUrlToFile = async (url: string) => {
    const response = await fetch(url);
    
    // data를 file 형태로 받음
    const data = await response.blob();
    
    // 확장자 가져오기
    const extend = url.split('.').pop();
    const fileName = url.split('/').pop();

    // 메타 데이터 생성
    const meta = { type: `image/${extend}`};

    // 특정한 url 가져와서 실제 파일 객체로 바꿔주기
    return new File([data], fileName as string, meta);
};

export const convertUrlsToFile = async (urls: string[]) => {
    const files: File[] = [];
    for (const url of urls) {
        const file = await convertUrlToFile(url);
        files.push(file);
    }
    return files;
}