<template>
  <div>
    <el-button>lalala</el-button>
  </div>
</template>
<script lang="ts">
/**
 * 页面核心数据结构体说明文档
 *
 *
 */
// import from

export default ({
  name: "index",
  props: {
    sampleP: {
      type: Number,
      default: 0,
    },
  },
  data() {
    return {
      sampleD: "value",
    };
  },
  computed: {
    /* sampleC() {
      return this.sampleD + "--";
    }, */
  },
  created() {},
  mounted() {},
  methods: {
    // sampleM() {},
  },
  watch: {
    // sampleP(n, o) {},
  },
});
</script>

<!--<style scoped>-->
<style lang="scss" scoped></style>
