import { NativeModules, Platform } from "react-native";

const { KioskMode } = NativeModules;

export const startKioskMode = async () => {
  if (Platform.OS === "android") {
    try {
      await KioskMode.startKioskMode();
      console.log("Kiosk Mode iniciado");
    } catch (error) {
      console.error("Erro ao iniciar o Kiosk Mode:", error);
    }
  } else {
    console.warn("Kiosk Mode não é suportado no iOS");
  }
};

export const stopKioskMode = async () => {
  if (Platform.OS === "android") {
    try {
      await KioskMode.stopKioskMode();
      console.log("Kiosk Mode desativado");
    } catch (error) {
      console.error("Erro ao desativar o Kiosk Mode:", error);
    }
  } else {
    console.warn("Kiosk Mode não é suportado no iOS");
  }
};
