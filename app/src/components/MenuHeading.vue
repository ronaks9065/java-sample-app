<template>
    <div>
        <div class="menu__top-container">
            <div class="menu__top">
                <img
                    src="../assets/images/logos/vw-ag-logo-4x.png"
                    alt="Volkswagen logo"
                    class="menu__logo"    
                />
                <img 
                    src="../assets/images/icons/vw-icon-close-grey-4x.png" 
                    alt="close" 
                    class="menu__icon" 
                    @click="commitMenu"
                />
            </div>
            <hr width="24%" style="display: block; margin: 0 auto 12px auto;">
            <img
                src="../assets/images/logos/kozern-logo-4x.png"
                alt="Volkswagen logo"
                class="menu__data-logo"    
            />
        </div>
    </div>
</template>

<script>
import {mapActions, mapState} from "vuex";

export default {
    name: "menu-heading",
    methods: {
        ...mapActions(["commitMenu"])
    }
};
</script>