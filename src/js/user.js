const { createApp } = Vue;

const app = createApp({
    data() {
        return {
            menu: '',
            loading: false
        };
    },
    methods: {
        async generateMenu() {
            this.menu = ''; // 메뉴를 초기화하여 애니메이션 효과를 트리거
            this.loading = true;
            try {
                const response = await axios.get('http://localhost:8080/menu/random');
                setTimeout(() => { // 로딩 상태를 좀 더 명확하게 하기 위해 지연 시간 추가
                    this.menu = response.data.name;
                    this.loading = false;
                }, 500); // 0.5초 지연
            } catch (error) {
                console.error('Error fetching menu:', error);
                this.loading = false;
            }
        }
    },
    mounted() {
        // 페이지 로드 시 메뉴를 가져오지 않습니다. 버튼을 클릭해야만 메뉴가 표시됩니다.
    }
});

app.mount('#app');
