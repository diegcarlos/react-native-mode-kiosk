declare module "react-native-mode-kiosk" {
  export function startKioskMode(): Promise<void>;

  export function stopKioskMode(): Promise<void>;
}
