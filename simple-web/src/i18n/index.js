import Vue from 'vue'
import VueI18n from 'vue-i18n'
import elementEnLocale from 'element-ui/lib/locale/lang/en'
import elementZhLocale from 'element-ui/lib/locale/lang/zh-CN'
import enLocale from './langs/en'
import zhCNLocale from './langs/zh_CN'

Vue.use(VueI18n)

const messages = {
  en: {
    ...enLocale,
    ...elementEnLocale
  },
  zhCN: {
    ...zhCNLocale,
    ...elementZhLocale
  }
}

// 从localStorage中拿到用户的语言选择，如果没有，那默认中文
const i18n = new VueI18n({
  locale: localStorage.lang || 'zhCN',
  messages
})

export default i18n
