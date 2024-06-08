
const app = Vue.createApp({
    data() {
        return {
            newMenu: '',
            menus: []
        };
    },
    methods: {
        async fetchMenuList() {
            try {
                const response = await axios.get('http://localhost:8080/menu');
                this.menus = response.data.map(menu => menu);
            } catch (error) {
                console.error('Error fetching menu list:', error);
            }
        },
        async addMenu() {
            if (this.newMenu) {
                const data = { name: this.newMenu };
                try {
                    const response = await axios.post('http://localhost:8080/menu', data, {
                        headers: {
                            "Content-Type": "application/json",
                        },
                    });
                    console.log('Menu added:', response.data);
                    this.menus.push(response.data);
                    this.newMenu = ''; // 입력 필드 초기화
                    this.fetchMenuList();
                } catch (error) {
                    console.error('Error adding menu:', error);
                }
            }
        },
        async confirmDelete(index) {
            if (confirm('메뉴를 삭제하시겠습니까?')) {
                this.deleteMenu(index);
            }
        },
        async deleteMenu(index) {
            // 인덱스가 유효한지 확인합니다.
            if (index >= 0 && index < this.menus.length) {
                const menuId = this.menus[index].id;
                try {
                    await axios.delete(`http://localhost:8080/menu/${menuId}`);
                    this.menus.splice(index, 1); // 목록에서 해당 메뉴 제거
                    console.log(`Menu with ID ${menuId} deleted.`);
                } catch (error) {
                    console.error('Error deleting menu:', error);
                }
            } else {
                console.error('Invalid index:', index);
            }
        },
    },
    mounted() {
        this.fetchMenuList(); // 앱이 마운트될 때 초기 메뉴 목록을 가져옵니다.
    }
});

app.mount('#app');